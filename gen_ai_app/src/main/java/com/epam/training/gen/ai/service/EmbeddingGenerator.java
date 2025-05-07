package com.epam.training.gen.ai.service;

import java.util.List;

public interface EmbeddingGenerator {
	List<Float> getEmbeddingFor(String text);
}
