package com.epam.training.gen.ai.controller;

import com.epam.training.gen.ai.service.EmbeddingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * REST controller responsible for handling embedding-related operations such as generating embeddings,
 * storing embeddings, and performing similarity search on text inputs. It exposes endpoints for building
 * and storing embeddings as well as searching for similar embeddings using a specified model.
 */
@RestController
@RequestMapping("/api/embedding")
@Tag(name = "EmbeddingController", description = "Embedding operations")
@RequiredArgsConstructor
public class EmbeddingController {

    /**
     * Handles embedding-related operations such as generating embeddings, storing them, and performing similarity searches.
     * This service is utilized by the {@code EmbeddingController} to delegate business logic
     * for embedding-related requests.
     */
    private final EmbeddingService embeddingService;

    /**
     * Builds embeddings for the provided text input using the specified model.
     *
     * @param input the text input to generate embeddings from
     * @param model the embedding model to use; defaults to "text-embedding-ada-002" if not provided
     * @return a {@code Mono} containing a list of lists of floating-point numbers representing the generated embeddings
     */
    @PostMapping("/build")
    @Operation(summary = "Build embedding from text")
    public Mono<List<List<Float>>> buildEmbedding(@RequestParam String input,
                                                  @RequestParam(defaultValue = "text-embedding-ada-002") String model) {
        return embeddingService.buildEmbeddingsFromChunks(input, model);
    }

    /**
     * Builds embeddings for the provided text input using the specified model and stores them in the vector store.
     *
     * @param input the text input to be processed into embeddings
     * @param model the name of the embedding model to use; defaults to "text-embedding-ada-002" if not specified
     * @return a {@code Mono<Void>} indicating the completion of the build and store operation
     */
    @PostMapping("/store")
    @Operation(summary = "Build and store embedding from text")
    public Mono<Void> buildAndStore(@RequestParam String input,
                                    @RequestParam(defaultValue = "text-embedding-ada-002") String model) {
        return embeddingService.buildAndStoreChunks(input, model);
    }

    /**
     * Searches for similar embeddings based on the provided input.
     *
     * @param input the text input to search for similar embeddings
     * @param limit the maximum number of results to retrieve; defaults to 5 if not specified
     * @param model the embedding model to use for the search; defaults to "text-embedding-ada-002" if not specified
     * @return a {@code Mono} containing a list of strings representing the search results
     */
    @PostMapping("/search")
    @Operation(summary = "Search for similar embeddings")
    public Mono<List<String>> search(@RequestParam String input,
                                     @RequestParam(defaultValue = "5") int limit,
                                     @RequestParam(defaultValue = "text-embedding-ada-002") String model) {
        return embeddingService.search(input, limit, model);
    }
}

