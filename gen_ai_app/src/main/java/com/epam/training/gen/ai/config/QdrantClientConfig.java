package com.epam.training.gen.ai.config;

import io.qdrant.client.QdrantClient;
import io.qdrant.client.QdrantGrpcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the Qdrant client integration with the application.
 * This class defines beans and configuration properties required to establish connection
 * and interact with the Qdrant vector database service.
 * <p>
 * The Qdrant client is configured using properties injected from the application's
 * configuration, such as the hostname, port, and whether to enable TLS.
 * These settings are used to initialize and provide a QdrantClient instance.
 */
@Configuration
public class QdrantClientConfig {
    /**
     * Represents the hostname or IP address of the Qdrant server.
     * <p>
     * This value is injected from the application's configuration
     * properties using the `spring.ai.vectorstore.qdrant.host` key.
     * It is used to establish communication with the Qdrant service
     * for vector storage and retrieval operations.
     */
    @Value("${spring.ai.vectorstore.qdrant.host}")
    private String host;

    /**
     * Represents the port number used to connect to the Qdrant vector store's gRPC service.
     * <p>
     * This value is injected from the application properties using the Spring property key
     * `spring.ai.vectorstore.qdrant.port`.
     * It defines the network port through which communication with the Qdrant server occurs.
     */
    @Value("${spring.ai.vectorstore.qdrant.port}")
    private int port;

    /**
     * Indicates whether TLS (Transport Layer Security) is enabled for communication
     * with the Qdrant vector database.
     * <p>
     * This value is injected from the application properties using the Spring
     * `@Value` annotation, with the property key `spring.ai.vectorstore.qdrant.use-tls`.
     * This setting determines if secure communication over TLS is required for
     * connecting to the Qdrant service.
     */
    @Value("${spring.ai.vectorstore.qdrant.use-tls}")
    private boolean useTLS;

    /**
     * Creates and provides a QdrantClient bean for interaction with Qdrant vector storage services.
     * Configures the client using host, port, and TLS settings defined in application properties.
     *
     * @return a configured QdrantClient instance for communication with the Qdrant vector database
     */
    @Bean
    public QdrantClient qdrantClient() {
        QdrantGrpcClient grpcClient = QdrantGrpcClient.newBuilder(host, port, useTLS).build();
        return new QdrantClient(grpcClient);
    }
}
