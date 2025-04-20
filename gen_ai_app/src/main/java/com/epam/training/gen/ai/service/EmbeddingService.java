package com.epam.training.gen.ai.service;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.models.EmbeddingsOptions;
import com.epam.training.gen.ai.model.SmartChunker;
import com.epam.training.gen.ai.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Service class responsible for handling text embeddings using AI-based models and providing
 * functionalities such as generating embeddings, performing semantic searches, and storing
 * embeddings in a persistent vector store.
 * <p>
 * This class integrates with an OpenAI asynchronous client to generate embeddings and
 * utilizes a vector store service to manage the storage and retrieval of embeddings.
 * It also includes logic for splitting input text into manageable chunks and processing
 * them individually.
 */
@Component
@RequiredArgsConstructor
public class EmbeddingService {

    /**
     * A constant representing a marker word used to identify or differentiate
     * embedding-related models. This marker word is utilized in logic where
     * the selection or handling of embedding models depends on the presence
     * of specific keywords in the model identifier.
     * <p>
     * The presence of this marker in a model identifier may determine whether
     * the model is treated as an embedding model, influencing further operations
     * such as generating embeddings or performing semantic searches.
     */
    public static final String EMBEDDING_MARKER_WORD = "embedd";
    /**
     * Represents an instance of the OpenAI asynchronous client used to perform
     * operations such as generating embeddings, processing queries, and invoking
     * AI-based functionalities asynchronously.
     * <p>
     * This client serves as a foundational component for integrating with the OpenAI API
     * and handling asynchronous interactions, facilitating the execution of embedding
     * and AI-driven activities within the {@code EmbeddingService}.
     */
    private final OpenAIAsyncClient openAIAsyncClient;
    /**
     * An instance of the {@code VectorStoreService} interface used to interact with an external vector store.
     * This service facilitates operations such as storing data embeddings and performing semantic search queries
     * against the stored embeddings.
     * <p>
     * The {@code VectorStoreService} is utilized by the methods of the {@code EmbeddingService} class to:
     * - Store chunks of text and their corresponding embeddings.
     * - Perform vector-based similarity searches for semantic search functionality.
     * <p>
     * This service is integral to managing and querying embeddings in a persistent storage medium, ensuring
     * efficient retrieval and storage of vectorized data.
     */
    private final VectorStoreService vectorStoreService;

    /**
     * Generates embeddings for a given text using the specified model.
     *
     * @param text       the input text for which embeddings need to be generated
     * @param modelValue the model identifier used for generating embeddings; if null, a default model is selected
     * @return a {@code Mono} emitting a list of {@code Float} values representing the embeddings for the input text
     */
    public Mono<List<Float>> getEmbeddings(String text, @Nullable String modelValue) {
        EmbeddingsOptions options = new EmbeddingsOptions(List.of(text));
        return Mono.from(openAIAsyncClient.getEmbeddings(getSelectedModel(modelValue), options))
                .map(result -> result.getData().get(0).getEmbedding());
    }

    /**
     * Splits the given input text into smaller chunks, generates embeddings for each chunk
     * using the specified model, and collects the embeddings into a list.
     *
     * @param input      the input text to be divided into chunks and processed
     * @param modelValue the model identifier used for generating embeddings; if null, a default model is selected
     * @return a {@code Mono} that emits a list of lists of {@code Float} values, where each inner list represents
     * the embeddings for a corresponding chunk
     */
    public Mono<List<List<Float>>> buildEmbeddingsFromChunks(String input, String modelValue) {
        List<String> chunks = SmartChunker.chunk(input);
        return Flux.fromIterable(chunks)
                .concatMap(chunk -> getEmbeddings(chunk, modelValue))
                .collectList();
    }

    /**
     * Splits the given input text into chunks, generates embeddings for each chunk using the specified model,
     * and stores the chunks with their corresponding embeddings in the vector store.
     *
     * @param input      the input text to be split into chunks and processed
     * @param modelValue the model identifier used for generating embeddings; if null, a default model is selected
     * @return a {@link Mono} that completes when all chunks and their embeddings are successfully stored
     */
    public Mono<Void> buildAndStoreChunks(String input, String modelValue) {
        List<String> chunks = SmartChunker.chunk(input);
        return Flux.fromIterable(chunks)
                .concatMap(chunk -> getEmbeddings(chunk, modelValue)
                        .flatMap(embedding -> vectorStoreService.upsert(chunk, embedding)))
                .then();
    }

    /**
     * Performs a semantic search operation by generating embeddings for the input string and querying
     * a vector store for similar entries based on the embedding.
     *
     * @param input      the search query string used to generate embeddings for similarity comparison
     * @param limit      the maximum number of search results to retrieve
     * @param modelValue the model identifier used for generating embeddings (can be null to select a default model)
     * @return a {@link Mono} emitting a list of search results represented as strings
     */
    public Mono<List<String>> search(String input, int limit, @Nullable String modelValue) {
        EmbeddingsOptions options = new EmbeddingsOptions(List.of(input));
        return Mono.from(openAIAsyncClient.getEmbeddings(getSelectedModel(modelValue), options))
                .map(result -> result.getData().get(0).getEmbedding())
                .flatMap(embedding -> vectorStoreService.search(input, embedding, limit));
    }

    /**
     * Selects the appropriate model based on the provided model identifier.
     * If the provided identifier contains a predefined marker word, it uses that model;
     * otherwise, it defaults to the predefined embedding model.
     *
     * @param modelValue the model identifier provided as input, which may be null or invalid
     * @return the selected model identifier value to be used for embeddings
     */
    private static String getSelectedModel(String modelValue) {
        return Model.fromValue(modelValue)
                .map(Model::value)
                .filter(val -> val.contains(EMBEDDING_MARKER_WORD))
                .orElse(Model.TEXT_EMBEDDING_ADA_002.value());
    }

}
