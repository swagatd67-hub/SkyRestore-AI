package com.skyrestore.backend.DTO.response;

import java.time.LocalDateTime;

import com.skyrestore.backend.enums.DisasterType;
import com.skyrestore.backend.enums.ReportStatus;

public class DisasterReportResponse {

    private Long id;
    private String title;
    private String description;
    private DisasterType disasterType;
    private Double latitude;
    private Double longitude;
    private String severity;
    private String imageUrl;
    private ReportStatus status;
    private String reportedBy;
    private LocalDateTime createdAt;

    public DisasterReportResponse() {
    }

    public DisasterReportResponse(Long id,
                                  String title,
                                  String description,
                                  DisasterType disasterType,
                                  Double latitude,
                                  Double longitude,
                                  String severity,
                                  String imageUrl,
                                  ReportStatus status,
                                  String reportedBy,
                                  LocalDateTime createdAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.disasterType = disasterType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
        this.imageUrl = imageUrl;
        this.status = status;
        this.reportedBy = reportedBy;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public DisasterType getDisasterType() { return disasterType; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getSeverity() { return severity; }
    public String getImageUrl() { return imageUrl; }
    public ReportStatus getStatus() { return status; }
    public String getReportedBy() { return reportedBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}