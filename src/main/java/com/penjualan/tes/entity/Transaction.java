package com.penjualan.tes.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private UUID userId;

  private UUID productId;

  private int quantity;
  private double totalPrice;
  private LocalDateTime transactionDate;

  private LocalDateTime createdAt;
  private String createdBy;

}

