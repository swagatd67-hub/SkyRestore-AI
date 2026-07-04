package com.skyrestore.backend.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.skyrestore.backend.DTO.request.DisasterReportRequest;
import com.skyrestore.backend.DTO.response.DisasterReportResponse;
import com.skyrestore.backend.Entity.DisasterReport;
import com.skyrestore.backend.Entity.User;
import com.skyrestore.backend.mapper.DisasterReportMapper;
import com.skyrestore.backend.repository.DisasterReportRepository;
import com.skyrestore.backend.repository.UserRepository;
import com.skyrestore.backend.service.DisasterReportService;

@Service
public class DisasterReportServiceImpl implements DisasterReportService {

    private final DisasterReportRepository reportRepository;
    private final UserRepository userRepository;
    private final DisasterReportMapper reportMapper;

    public DisasterReportServiceImpl(
            DisasterReportRepository reportRepository,
            UserRepository userRepository,
            DisasterReportMapper reportMapper) {

        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.reportMapper = reportMapper;
    }

    @Override
    public DisasterReportResponse createReport(
            DisasterReportRequest request,
            String email) {

        System.out.println("========== CREATE REPORT ==========");
        System.out.println("Email : " + email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        System.out.println("User Found : " + user.getEmail());

        DisasterReport report = reportMapper.toEntity(request);

        System.out.println("Mapper Completed");

        report.setReportedBy(user);

        System.out.println("Saving Report...");

        DisasterReport savedReport = reportRepository.save(report);

        System.out.println("Report Saved Successfully");

        return reportMapper.toResponse(savedReport);
    }

    @Override
    public List<DisasterReportResponse> getMyReports(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return reportRepository.findByReportedBy(user)
                .stream()
                .map(reportMapper::toResponse)
                .collect(Collectors.toList());
    }
   
}