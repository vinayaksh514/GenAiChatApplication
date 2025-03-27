package com.epam.training.gen.ai.controller;

import com.epam.training.gen.ai.history.SimpleKernelHistory;
import com.epam.training.gen.ai.model.Chat;
import com.epam.training.gen.ai.model.ChatBotResponse;
import com.epam.training.gen.ai.model.ChatRequest;
import com.epam.training.gen.ai.model.ChatResponse;
import com.epam.training.gen.ai.service.UserInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserInputController {

    private final UserInputService userInputService;
    private final SimpleKernelHistory kernelHistory;

    @PostMapping("/processRequest")
    public List<ChatResponse> getResponse(@RequestBody ChatRequest request){
        return userInputService.getResponse(request.getInputPrompt());
    }

    // added PromptExecutionSettings
    @PostMapping(value = "/task2")
    public ChatBotResponse getResponseFromHistory(@RequestBody Chat chat) {
        return Optional.ofNullable(kernelHistory)
                .map(kernelHistory -> kernelHistory.processWithHistory(chat))
                .orElseGet(ChatBotResponse::new);
    }

}