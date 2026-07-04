package com.skyrestore.backend.ai.dto;

public class CloudRemovalResponse {

    private boolean success;
    private String outputImage;
    private String message;

    public CloudRemovalResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getOutputImage() {
        return outputImage;
    }

    public void setOutputImage(String outputImage) {
        this.outputImage = outputImage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}