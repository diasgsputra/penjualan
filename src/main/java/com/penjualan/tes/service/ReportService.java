package com.penjualan.tes.service;

import com.penjualan.tes.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportService {

  @Autowired
  private TransactionRepository transactionRepository;


  public byte[] exportReportToPdf() {
    return new byte[0];
  }

}

