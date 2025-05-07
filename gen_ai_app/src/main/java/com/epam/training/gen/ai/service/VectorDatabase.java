package com.epam.training.gen.ai.service;

import java.util.List;

public interface VectorDatabase {
	
	void insert(List<Float> embedding, String text);
	
	String getMostSimilarTo(List<Float> embedding);

}
