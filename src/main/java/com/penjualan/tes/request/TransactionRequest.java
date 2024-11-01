package com.penjualan.tes.request;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TransactionRequest {
  @NotNull()
  private UUID productId;

  @NotNull()
  private Integer quantity;
}
