package com.epam.training.gen.ai.service;

import com.epam.training.gen.ai.model.Reactive;
import io.qdrant.client.QdrantClient;
import io.qdrant.client.grpc.Collections;
import io.qdrant.client.grpc.JsonWithInt;
import io.qdrant.client.grpc.Points.*;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Service implementation for managing vector-based storage and retrieval using Qdrant.
 * This service provides mechanisms for ensuring the proper setup of vector collections,
 * upserting vectorized data points, and searching for vectors based on similarity.
 * It utilizes a Qdrant client to communicate with the Qdrant vector database.
 * <p>
 * The primary functionality includes:
 * - Creating and ensuring the existence of collections in the Qdrant system.
 * - Adding or updating vector data points with associated payloads.
 * - Searching for vector matches based on query embeddings and associated text payloads.
 */
@Slf4j
@Service
public class QdrantVectorStoreService implements VectorStoreService, Reactive {

    /**
     * A constant key used for identifying and storing text data within the vector storage system.
     * This key is used in conjunction with payload data when performing operations such as
     * upserting and searching for vectors in the QdrantVectorStoreService.
     */
    public static final String VECTOR_STORE_TEXT_KEY = "text";

    /**
     * The default size of the vector used for embedding in the Qdrant vector store.
     * This constant defines the dimensionality of vectors managed within the storage system.
     * It is used during collection creation and vector upsertion to ensure compatibility
     * with the configured vector storage format.
     */
    public static final int DEFAULT_VECTOR_SIZE = 1536;

    /**
     * Default timeout duration in seconds used for operations that require a
     * time-bound execution. This constant is typically utilized when interacting
     * with external systems or performing asynchronous operations where a timeout
     * needs to be defined to avoid prolonged wait times.
     */
    public static final int DEFAULT_TIMEOUT = 5;

    /**
     * A client for interacting with a Qdrant vector database.
     * Provides operations for managing vector collections, inserting/upserting vectors,
     * and performing vector-based searches within the database.
     * Used internally by {@link QdrantVectorStoreService} to facilitate communication with the database.
     */
    private final QdrantClient qdrantClient;

    /**
     * The name of the Qdrant collection used for storing vector data.
     * <p>
     * This property is injected from the application configuration and defines
     * the specific collection within the Qdrant vector database where vector
     * embeddings are stored and retrieved. The collection name should correspond
     * to a valid collection in the Qdrant database.
     * <p>
     * The value of this property is typically configured using the `vector.collection.name`
     * property in the application's environment or configuration files.
     */
    @Value("${vector.collection.name}")
    private String collectionName;

    /**
     * Constructs a new instance of QdrantVectorStoreService.
     *
     * @param qdrantClient the Qdrant client used for interacting with the Qdrant database
     */
    public QdrantVectorStoreService(QdrantClient qdrantClient) {
        this.qdrantClient = qdrantClient;
    }

    /**
     * Ensures that a collection with the configured name exists within the Qdrant system.
     * If the collection does not exist, it attempts to create a new one with the specified
     * configuration, including vector size and distance metric.
     * <p>
     * Logging is performed to indicate whether the collection already exists or is being created.
     * In case of an error during collection creation, an error message is logged.
     * <p>
     * This method is executed automatically after the construction of the bean, as annotated by {@code @PostConstruct}.
     * <p>
     * The collection configuration includes:
     * - Vector size: 1536
     * - Distance metric: Cosine similarity
     * <p>
     * Exceptions encountered during the process are logged but not propagated, allowing the application to continue running.
     */
    @PostConstruct
    public void ensureCollectionExists() {
        Collections.Distance distance = Collections.Distance.Cosine;

        try {
            qdrantClient.getCollectionInfoAsync(collectionName, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .get(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

            log.info("Qdrant collection '{}' already exists — skipping creation.", collectionName);
        } catch (Exception ex) {
            log.warn("Qdrant collection '{}' not found or failed to fetch. Attempting to create...", collectionName);

            Collections.CreateCollection request = Collections.CreateCollection.newBuilder()
                    .setCollectionName(collectionName)
                    .setVectorsConfig(Collections.VectorsConfig.newBuilder()
                            .setParams(Collections.VectorParams.newBuilder()
                                    .setSize(DEFAULT_VECTOR_SIZE)
                                    .setDistance(distance)
                                    .build())
                            .build())
                    .build();

            try {
                qdrantClient.createCollectionAsync(request);
                log.info("Created Qdrant collection '{}'.", collectionName);
            } catch (Exception createEx) {
                log.error("Failed to create Qdrant collection '{}': {}", collectionName, createEx.getMessage(), createEx);
            }
        }
    }

    /**
     * Upserts a data point into the Qdrant vector store with the provided text and embedding vector.
     * The method creates a new data point with a unique identifier, associates it with the embedding vector
     */
    @Override
    public Mono<Void> upsert(String text, List<Float> embedding) {
        PointStruct point = PointStruct.newBuilder()
                .setId(PointId.newBuilder().setUuid(UUID.randomUUID().toString()).build())
                .setVectors(Vectors.newBuilder()
                        .setVector(Vector.newBuilder()
                                .addAllData(embedding)
                                .build())
                        .build())
                .putAllPayload(Map.of(
                        VECTOR_STORE_TEXT_KEY, JsonWithInt.Value.newBuilder().setStringValue(text).build()
                ))
                .build();

        UpsertPoints upsert = UpsertPoints.newBuilder()
                .setCollectionName(collectionName)
                .addPoints(point)
                .build();

        try {
            return this.toMono(qdrantClient.upsertAsync(upsert))
                    .doOnNext(result -> log.info("Qdrant upsert status: {}", result.getStatus()))
                    .then();
        } catch (Exception e) {
            return Mono.error(new RuntimeException("Qdrant upsert failed", e));
        }
    }

    /**
     * Searches for relevant text entities based on the provided query embedding and a text parameter.
     *
     * @param text           the text describing the search context or additional information for the query
     * @param queryEmbedding a list of floating-point values representing the vector embedding for the search query
     * @param limit          the maximum number of results to return
     * @return a Mono that emits a list of strings representing the retrieved text entities corresponding to the search results
     */
    @Override
    public Mono<List<String>> search(String text, List<Float> queryEmbedding, int limit) {
        SearchPoints request = SearchPoints.newBuilder()
                .setCollectionName(collectionName)
                .addAllVector(queryEmbedding)
                .setLimit(limit)
                .setWithPayload(
                        WithPayloadSelector.newBuilder()
                                .setEnable(true)
                                .build()
                )
                .build();

        return this.toMono(qdrantClient.searchAsync(request))
                .map(scoredPoints -> scoredPoints.stream()
                        .map(scoredPoint -> scoredPoint.getPayloadMap().getOrDefault(
                                VECTOR_STORE_TEXT_KEY,
                                JsonWithInt.Value.newBuilder().setStringValue("").build()
                        ))
                        .map(JsonWithInt.Value::getStringValue)
                        .collect(Collectors.toList()));
    }
}

