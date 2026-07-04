package com.skyrestore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyrestore.backend.Entity.DisasterReport;
import com.skyrestore.backend.Entity.User;

@Repository
public interface DisasterReportRepository extends JpaRepository<DisasterReport, Long> {

    List<DisasterReport> findByReportedBy(User user);

}