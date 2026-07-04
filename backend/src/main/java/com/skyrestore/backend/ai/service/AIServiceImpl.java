package com.skyrestore.backend.ai.service;

import org.springframework.stereotype.Service;

import com.skyrestore.backend.ai.dto.AIAnalysisResponse;
import com.skyrestore.backend.ai.parser.GeminiResponseParser;

@Service
public class AIServiceImpl implements AIService {

    private final GeminiVisionService geminiVisionService;
    private final GeminiResponseParser parser;

    public AIServiceImpl(
            GeminiVisionService geminiVisionService,
            GeminiResponseParser parser) {

        this.geminiVisionService = geminiVisionService;
        this.parser = parser;
    }

    @Override
    public AIAnalysisResponse analyzeImage(String imageUrl) {

        String prompt = """
You are an expert Disaster Management AI.

Analyze the disaster image available at this URL:

%s

IMPORTANT:
Return ONLY valid JSON.

{
  "imageUrl":"%s",
  "disasterType":"",
  "severity":"",
  "confidence":0,
  "description":"",
  "peopleDetected":false,
  "peopleCount":0,
  "vehiclesDetected":0,
  "buildingDamage":"",
  "roadBlocked":false,
  "bridgeDamage":false,
  "fireDetected":false,
  "rescuePriority":"",
  "recommendedAction":""
}

Do not return markdown.
Do not use ```json.
Return only JSON.
""".formatted(imageUrl, imageUrl);

        String geminiResponse =
                geminiVisionService.analyzeImage(prompt);

        return parser.parse(geminiResponse);
    }
}