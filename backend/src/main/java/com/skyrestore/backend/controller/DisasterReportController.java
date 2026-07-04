package com.skyrestore.backend.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.skyrestore.backend.DTO.request.DisasterReportRequest;
import com.skyrestore.backend.DTO.response.DisasterReportResponse;
import com.skyrestore.backend.service.DisasterReportService;

@RestController
@RequestMapping("/api/reports")
public class DisasterReportController {

    private final DisasterReportService reportService;

    public DisasterReportController(
            DisasterReportService reportService) {

        this.reportService = reportService;
    }

    @PostMapping
    public DisasterReportResponse createReport(
            @RequestBody DisasterReportRequest request,
            Authentication authentication) {

        System.out.println("========== CONTROLLER ==========");
        System.out.println(authentication);
        System.out.println(authentication.getName());

        return reportService.createReport(
                request,
                authentication.getName());
    }

    @GetMapping("/my")
    public List<DisasterReportResponse> getMyReports(
            Authentication authentication) {

        return reportService.getMyReports(
                authentication.getName());
    }
}