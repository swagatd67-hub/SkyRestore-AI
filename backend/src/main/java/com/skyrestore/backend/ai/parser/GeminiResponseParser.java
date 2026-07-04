package com.skyrestore.backend.ai.parser;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.skyrestore.backend.ai.dto.AIAnalysisResponse;

@Component
public class GeminiResponseParser {

    private final Gson gson = new Gson();

    public AIAnalysisResponse parse(String response) {

        try {

            response = response
                    .replace("```json", "")
                    .replace("```", "")
                    .trim();

            return gson.fromJson(response, AIAnalysisResponse.class);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to parse Gemini JSON Response",
                    e);

        }

    }

}