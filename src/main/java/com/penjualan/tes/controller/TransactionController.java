package com.penjualan.tes.controller;

import com.penjualan.tes.request.TransactionRequest;
import com.penjualan.tes.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
  @Autowired
  private TransactionService transactionService;

  @PostMapping
  public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest request) {
    transactionService.createTransaction(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}

