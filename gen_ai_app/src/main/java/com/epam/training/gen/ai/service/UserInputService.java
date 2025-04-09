package com.epam.training.gen.ai.service;

import com.epam.training.gen.ai.model.ChatResponse;
import com.microsoft.semantickernel.Kernel;
import com.microsoft.semantickernel.orchestration.InvocationContext;
import com.microsoft.semantickernel.services.chatcompletion.ChatCompletionService;
import com.microsoft.semantickernel.services.chatcompletion.ChatHistory;
import com.microsoft.semantickernel.services.chatcompletion.ChatMessageContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInputService {

    @Autowired
    private final SemanticKernelService semanticKernelService;

    @Autowired
    ChatCompletionService chatCompletionService;

    @Autowired
    Kernel kernel;

    @Autowired
    InvocationContext invocationContext;

    public UserInputService(SemanticKernelService semanticKernelService) {
        this.semanticKernelService = semanticKernelService;
    }

    public List<ChatResponse> getResponse(String input){
        return semanticKernelService.getResponse(input);
    }

    public List<String> getChatHistory(String prompt) {
        ChatHistory history = new ChatHistory();
        history.addUserMessage(prompt);

        List<ChatMessageContent<?>> results = chatCompletionService
                .getChatMessageContentsAsync(history, kernel, invocationContext)
                .block();

        System.out.println("Assistant > " + (results != null ? results.getFirst() : null));
        return results != null ? results.stream().map(ChatMessageContent::getContent).toList() : null;
    }
}
