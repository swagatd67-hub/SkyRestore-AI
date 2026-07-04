package com.skyrestore.backend.ai.controller;

import org.springframework.web.bind.annotation.*;

import com.skyrestore.backend.ai.dto.AIAnalysisRequest;
import com.skyrestore.backend.ai.dto.AIAnalysisResponse;
import com.skyrestore.backend.ai.service.AIService;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/analyze")
    public AIAnalysisResponse analyzeImage(
            @RequestBody AIAnalysisRequest request) {

        return aiService.analyzeImage(request.getImageUrl());
    }
}