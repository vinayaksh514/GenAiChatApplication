package com.epam.training.gen.ai.service;

import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Service interface for managing operations related to a vector store.
 * Provides methods for inserting and retrieving text data associated with vector embeddings.
 */
public interface VectorStoreService {

    /**
     * Upserts a text and its associated vector embedding into the vector store.
     * If the text already exists, updates its embedding; otherwise, inserts a new entry.
     *
     * @param text      the text to be stored or updated in the vector store
     * @param embedding the vector representation of the text, consisting of a list of floating-point values
     * @return a {@link Mono} that completes when the operation is done
     */
    Mono<Void> upsert(String text, List<Float> embedding);

    /**
     * Searches for similar text entries in the vector store based on the provided query embedding.
     *
     * @param text           the query text used to refine or filter results
     * @param queryEmbedding the vector representation of the query text, consisting of floating-point values
     * @param limit          the maximum number of matching text entries to retrieve
     * @return a {@link Mono} emitting a list of text entries matching the query, constrained to the specified limit
     */
    Mono<List<String>> search(String text, List<Float> queryEmbedding, int limit);
}
