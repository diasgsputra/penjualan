package com.penjualan.tes.service;

import com.penjualan.tes.entity.Product;
import com.penjualan.tes.entity.Transaction;
import com.penjualan.tes.repository.ProductRepository;
import com.penjualan.tes.repository.TransactionRepository;
import com.penjualan.tes.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  private ProductRepository productRepository;

  @Transactional
  public Transaction createTransaction(TransactionRequest request) {
    Transaction transaction = new Transaction();
    transaction.setId(UUID.randomUUID());
    transaction.setTransactionDate(LocalDateTime.now());

    Product product = productRepository.findById(transaction.getProductId())
        .orElseThrow(() -> new RuntimeException("Product not found"));

    if (product.getStock() < transaction.getQuantity()) {
      throw new RuntimeException("Insufficient stock for product: " + product.getName());
    }

    product.setStock(product.getStock() - transaction.getQuantity());
    productRepository.save(product);

    transaction.setTotalPrice(product.getPrice() * transaction.getQuantity());

    transaction.setCreatedAt(LocalDateTime.now());
    transaction.setCreatedBy("System");

    return transactionRepository.save(transaction);
  }

  public void processRefund(UUID transactionId) {
    Transaction transaction = transactionRepository.findById(transactionId)
        .orElseThrow(() -> new RuntimeException("Transaction not found"));

    Product product = productRepository.findById(transaction.getProductId())
        .orElseThrow(() -> new RuntimeException("Product not found"));

    product.setStock(product.getStock() + transaction.getQuantity());
    productRepository.save(product);

    transactionRepository.delete(transaction);
  }
}


