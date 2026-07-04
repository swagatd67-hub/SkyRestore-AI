package com.skyrestore.backend.mapper;

import org.springframework.stereotype.Component;

import com.skyrestore.backend.DTO.request.DisasterReportRequest;
import com.skyrestore.backend.DTO.response.DisasterReportResponse;
import com.skyrestore.backend.Entity.DisasterReport;

@Component
public class DisasterReportMapper {

    public DisasterReport toEntity(DisasterReportRequest request) {

        DisasterReport report = new DisasterReport();

        report.setTitle(request.getTitle());
        report.setDescription(request.getDescription());
        report.setDisasterType(request.getDisasterType());
        report.setLatitude(request.getLatitude());
        report.setLongitude(request.getLongitude());
        report.setSeverity(request.getSeverity());
        report.setImageUrl(request.getImageUrl());

        return report;
    }

    public DisasterReportResponse toResponse(DisasterReport report) {

        return new DisasterReportResponse(
                report.getId(),
                report.getTitle(),
                report.getDescription(),
                report.getDisasterType(),
                report.getLatitude(),
                report.getLongitude(),
                report.getSeverity(),
                report.getImageUrl(),
                report.getStatus(),
                report.getReportedBy().getName(),
                report.getCreatedAt()
        );
    }
}