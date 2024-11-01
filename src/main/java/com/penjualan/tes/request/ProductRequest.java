package com.penjualan.tes.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
  private String name;

  private String description;

  @NotNull()
  private Double price;

  @NotNull()
  private Integer stock;
}
