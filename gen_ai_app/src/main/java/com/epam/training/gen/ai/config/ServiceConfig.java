package com.epam.training.gen.ai.config;

import com.epam.training.gen.ai.service.SemanticKernelService;
import com.epam.training.gen.ai.service.UserInputService;
import com.microsoft.semantickernel.Kernel;
import com.microsoft.semantickernel.orchestration.InvocationContext;
import com.microsoft.semantickernel.services.chatcompletion.ChatCompletionService;
import com.microsoft.semantickernel.services.chatcompletion.ChatHistory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public UserInputService promptService(SemanticKernelService semanticKernelService) {
        return new UserInputService(semanticKernelService);
    }

    @Bean
    public SemanticKernelService semanticKernelService(ChatCompletionService chatCompletionService,
                                                       InvocationContext invocationContext,
                                                       ChatHistory chatHistory,
                                                       Kernel kernel

    ) {
        return new SemanticKernelService(chatCompletionService, invocationContext, chatHistory, kernel);
    }
}