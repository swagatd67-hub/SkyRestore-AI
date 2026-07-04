package com.skyrestore.backend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.skyrestore.backend.ai.client.FastApiClient;
import com.skyrestore.backend.ai.dto.AIAnalysisResponse;
import com.skyrestore.backend.ai.service.AIService;
import com.skyrestore.backend.service.ImageUploadService;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin("*")
public class ImageUploadController {

    private final FastApiClient fastApiClient;

    private final ImageUploadService imageUploadService;

    private final AIService aiService;

    public ImageUploadController(
            FastApiClient fastApiClient,
            ImageUploadService imageUploadService,
            AIService aiService) {

        this.fastApiClient = fastApiClient;
        this.imageUploadService = imageUploadService;
        this.aiService = aiService;
    }

    @PostMapping(
            value = "/analyze",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AIAnalysisResponse uploadAndAnalyze(

            @RequestParam("file") MultipartFile file) {

        // Step 1
        byte[] cleanImage =
                fastApiClient.removeClouds(file);

        // Step 2
        String imageUrl =
                imageUploadService.uploadProcessedImage(cleanImage);

        // Step 3
        AIAnalysisResponse response =
                aiService.analyzeImage(imageUrl);

        // Step 4
        response.setImageUrl(imageUrl);

        return response;
    }
}