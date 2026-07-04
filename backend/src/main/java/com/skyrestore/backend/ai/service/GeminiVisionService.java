package com.skyrestore.backend.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class GeminiVisionService {

    @Value("${gemini.api.key}")
    private String apiKey;

    public String analyzeImage(String prompt) {

        try {

            Client client = Client.builder()
                    .apiKey(apiKey)
                    .build();

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-2.5-flash",
                            prompt,
                            null);

            return response.text();

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);
        }
    }
}