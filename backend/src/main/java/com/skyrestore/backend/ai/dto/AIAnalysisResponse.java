package com.skyrestore.backend.ai.dto;

public class AIAnalysisResponse {

    private String imageUrl;

    private String disasterType;

    private String severity;

    private double confidence;

    private String description;

    private boolean peopleDetected;

    private int peopleCount;

    private int vehiclesDetected;

    private String buildingDamage;

    private boolean roadBlocked;

    private boolean bridgeDamage;

    private boolean fireDetected;

    private String rescuePriority;

    private String recommendedAction;

    public AIAnalysisResponse() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPeopleDetected() {
        return peopleDetected;
    }

    public void setPeopleDetected(boolean peopleDetected) {
        this.peopleDetected = peopleDetected;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public int getVehiclesDetected() {
        return vehiclesDetected;
    }

    public void setVehiclesDetected(int vehiclesDetected) {
        this.vehiclesDetected = vehiclesDetected;
    }

    public String getBuildingDamage() {
        return buildingDamage;
    }

    public void setBuildingDamage(String buildingDamage) {
        this.buildingDamage = buildingDamage;
    }

    public boolean isRoadBlocked() {
        return roadBlocked;
    }

    public void setRoadBlocked(boolean roadBlocked) {
        this.roadBlocked = roadBlocked;
    }

    public boolean isBridgeDamage() {
        return bridgeDamage;
    }

    public void setBridgeDamage(boolean bridgeDamage) {
        this.bridgeDamage = bridgeDamage;
    }

    public boolean isFireDetected() {
        return fireDetected;
    }

    public void setFireDetected(boolean fireDetected) {
        this.fireDetected = fireDetected;
    }

    public String getRescuePriority() {
        return rescuePriority;
    }

    public void setRescuePriority(String rescuePriority) {
        this.rescuePriority = rescuePriority;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }
}