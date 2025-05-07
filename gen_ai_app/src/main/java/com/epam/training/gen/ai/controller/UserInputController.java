package com.epam.training.gen.ai.controller;

import com.epam.training.gen.ai.history.SimpleKernelHistory;
import com.epam.training.gen.ai.model.Chat;
import com.epam.training.gen.ai.model.ChatBotResponse;
import com.epam.training.gen.ai.model.ChatRequest;
import com.epam.training.gen.ai.model.ChatResponse;
import com.epam.training.gen.ai.service.DocumentSearchService;
import com.epam.training.gen.ai.service.UserInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserInputController {

    private final UserInputService userInputService;
    private final SimpleKernelHistory kernelHistory;
    private final RestTemplate restTemplate;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserInputController.class);

    @Autowired
    private DocumentSearchService documentSearchService;

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

    /*
  user prompt like below as we are using light Model
  1. Turn on light 2
  2. Please turn on the lamp
  3. Turn on light 2 and light 3
  */
    @GetMapping("/chat/plugin")
    public String chatHistory(@RequestParam String prompt){
        return userInputService.getChatHistory(prompt).toString();
    }

    @GetMapping("/augment")
    public ResponseEntity<Map<String, String>> augment(@RequestParam String prompt) {
        log.info("User prompt: " + prompt);

        String result = documentSearchService.augmentedQuery(prompt);
        log.info("Chat-bot response: " + result);

        Map<String, String> response = new HashMap<>();
        response.put("output", result);
        return ResponseEntity.ok(response);
    }
}