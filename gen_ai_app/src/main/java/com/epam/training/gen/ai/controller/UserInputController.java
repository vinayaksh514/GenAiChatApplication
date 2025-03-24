package com.epam.training.gen.ai.controller;

import com.epam.training.gen.ai.model.ChatRequest;
import com.epam.training.gen.ai.model.ChatResponse;
import com.epam.training.gen.ai.service.SimpleKernelHistory;
import com.epam.training.gen.ai.service.UserInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserInputController {

    UserInputService userInputService;

    @PostMapping("/processRequest")
    public List<ChatResponse> getResponse(@RequestBody ChatRequest request){
        return userInputService.getResponse(request.getInputPrompt());
    }

}