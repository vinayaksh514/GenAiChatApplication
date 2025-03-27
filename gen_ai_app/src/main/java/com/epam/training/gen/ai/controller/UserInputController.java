package com.epam.training.gen.ai.controller;

import com.epam.training.gen.ai.history.SimpleKernelHistory;
import com.epam.training.gen.ai.model.Chat;
import com.epam.training.gen.ai.model.ChatBotResponse;
import com.epam.training.gen.ai.model.ChatRequest;
import com.epam.training.gen.ai.model.ChatResponse;
import com.epam.training.gen.ai.service.UserInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserInputController {

    private final UserInputService userInputService;
    private final SimpleKernelHistory kernelHistory;
    private final RestTemplate restTemplate;

    @Value("${epam.dial.deployment-names-api}")
    private String DEPLOYMENT_NAMES_URL;


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

    // retrieved deployment names
    @GetMapping(value = "getDeploymentNames")
    public ResponseEntity<String> getDeploymentNames() {
        return new ResponseEntity<>(
                Optional.ofNullable(restTemplate.getForObject(DEPLOYMENT_NAMES_URL, String.class))
                        .orElseThrow(),
                HttpStatus.OK);
    }
}