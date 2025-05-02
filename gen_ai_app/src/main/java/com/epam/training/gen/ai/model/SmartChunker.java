package com.epam.training.gen.ai.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The SmartChunker class provides functionality for splitting large blocks of text into
 * smaller, semantically meaningful chunks. It uses sentence-ending punctuation and
 * paragraph breaks as semantic boundaries for splitting.
 * <p>
 * Each chunk may include a configurable number of overlapping sentences from the
 * preceding chunk to provide contextual continuity. This feature is useful when processing
 * text data for tasks such as natural language processing, summarization, or context-sensitive
 * analysis.
 * <p>
 * The class includes methods to perform chunking based on a default or user-specified
 * overlap sentence value.
 */
public class SmartChunker {

    /**
     * The default number of sentences to include as overlap between adjacent chunks
     * during text segmentation. This constant is used to provide context for each
     * chunk by including a specified number of sentences from the preceding chunk.
     * <p>
     * The value is set to 1, meaning one sentence of overlap is added by default
     * to the beginning of each subsequent chunk.
     */
    private static final int DEFAULT_OVERLAP_SENTENCES = 1;

    /**
     * A regular expression pattern used for splitting text into semantic units
     * based on sentence-ending punctuation and paragraph breaks.
     * <p>
     * The pattern matches:
     * - Whitespace following a period (.), exclamation mark (!), or question mark (?)
     * to identify sentence boundaries.
     * - Double newline characters (\n\n) to identify paragraph boundaries.
     * <p>
     * This regex is typically used when segmenting larger text bodies into smaller,
     * semantically meaningful chunks for further processing or analysis.
     */
    private static final String SEMANTIC_SPLIT_REGEX = "(?<=[\\.\\!\\?])\\s+|\\n\\n";

    /**
     * Splits the provided text into smaller chunks using the default overlap sentences value
     * for context. Each chunk uses semantic boundaries, such as sentence endings, for splitting.
     *
     * @param text the input text to be split into chunks; must not be null or blank
     * @return a list of text chunks, with overlapping sentences for context where applicable;
     * returns an empty list if the input text is null or blank
     */
    public static List<String> chunk(String text) {
        return chunk(text, DEFAULT_OVERLAP_SENTENCES);
    }

    /**
     * Splits the provided text into chunks based on semantic boundaries defined by
     * the regex pattern. Each chunk includes a specified number of overlapping
     * sentences from the preceding chunk for context.
     *
     * @param text             the input text to be split into semantic chunks; must not be null or blank
     * @param overlapSentences the number of preceding sentences to include as overlap in each chunk
     * @return a list of text chunks, each with overlapping context sentences if applicable;
     * an empty list if input text is null or blank
     */
    public static List<String> chunk(String text, int overlapSentences) {
        if (text == null || text.isBlank()) return List.of();

        String[] units = text.split(SEMANTIC_SPLIT_REGEX);
        List<String> chunks = new ArrayList<>();

        for (int i = 0; i < units.length; i++) {
            StringBuilder chunk = new StringBuilder();

            // Add overlap from previous sentences
            int start = Math.max(i - overlapSentences, 0);
            for (int j = start; j <= i; j++) {
                chunk.append(units[j].trim()).append(" ");
            }

            chunks.add(chunk.toString().trim());
        }

        return chunks;
    }

}
