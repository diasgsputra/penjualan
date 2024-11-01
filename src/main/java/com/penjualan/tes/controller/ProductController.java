package com.penjualan.tes.controller;

import com.penjualan.tes.entity.Product;
import com.penjualan.tes.request.ProductRequest;
import com.penjualan.tes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<?> addProduct(@RequestBody ProductRequest request) {
    productService.addProduct(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  public ResponseEntity<List<Product>> getProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@PathVariable UUID id, @RequestBody ProductRequest request) {
    productService.updateProduct(id, request);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok().build();
  }
}

