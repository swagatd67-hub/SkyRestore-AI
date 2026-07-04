package com.skyrestore.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

    // Existing method
    String uploadImage(MultipartFile file);

    // New method
    String uploadProcessedImage(byte[] imageBytes);
}