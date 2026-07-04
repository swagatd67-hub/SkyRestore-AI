package com.skyrestore.backend.ai.service;

import com.skyrestore.backend.ai.dto.AIAnalysisResponse;

public interface AIService {

    AIAnalysisResponse analyzeImage(String imageUrl);

}