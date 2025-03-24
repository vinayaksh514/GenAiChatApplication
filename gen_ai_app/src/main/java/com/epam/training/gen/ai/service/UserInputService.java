package com.epam.training.gen.ai.service;

import com.epam.training.gen.ai.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInputService {

    @Autowired
    private final SemanticKernelService semanticKernelService;

    public UserInputService(SemanticKernelService semanticKernelService) {
        this.semanticKernelService = semanticKernelService;
    }

    public List<ChatResponse> getResponse(String input){
        return semanticKernelService.getResponse(input);
    }
}
