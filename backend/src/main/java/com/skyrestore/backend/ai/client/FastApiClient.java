package com.skyrestore.backend.ai.client;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FastApiClient {

    private static final String FASTAPI_URL =
            "http://localhost:8000/cloud/remove";

    private final RestTemplate restTemplate = new RestTemplate();

    public byte[] removeClouds(MultipartFile file) {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            ByteArrayResource resource =
                    new ByteArrayResource(file.getBytes()) {

                        @Override
                        public String getFilename() {
                            return file.getOriginalFilename();
                        }
                    };

            MultiValueMap<String, Object> body =
                    new LinkedMultiValueMap<>();

            body.add("file", resource);

            HttpEntity<MultiValueMap<String, Object>> request =
                    new HttpEntity<>(body, headers);

            ResponseEntity<byte[]> response =
                    restTemplate.postForEntity(
                            FASTAPI_URL,
                            request,
                            byte[].class);

            if (!response.getStatusCode().is2xxSuccessful()
                    || response.getBody() == null) {

                throw new RuntimeException(
                        "Cloud removal failed.");
            }

            return response.getBody();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to communicate with FastAPI",
                    e);
        }
    }}