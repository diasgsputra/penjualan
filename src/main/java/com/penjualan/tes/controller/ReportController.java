package com.penjualan.tes.controller;

import com.penjualan.tes.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
  @Autowired
  private ReportService reportService;

  @GetMapping("/export")
  public ResponseEntity<?> exportReport() {
    reportService.exportReportToPdf();
    return ResponseEntity.ok().build();
  }
}
