package com.skyrestore.backend.service;

import java.util.List;

import com.skyrestore.backend.DTO.request.DisasterReportRequest;
import com.skyrestore.backend.DTO.response.DisasterReportResponse;

public interface DisasterReportService {

    DisasterReportResponse createReport(
            DisasterReportRequest request,
            String email);

    List<DisasterReportResponse> getMyReports(String email);

}