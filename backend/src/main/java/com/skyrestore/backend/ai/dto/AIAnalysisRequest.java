package com.skyrestore.backend.ai.dto;

public class AIAnalysisRequest {

    private String imageUrl;

    public AIAnalysisRequest() {
    }

    public AIAnalysisRequest(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}