package com.penjualan.tes.service;

import com.penjualan.tes.entity.Product;
import com.penjualan.tes.repository.ProductRepository;
import com.penjualan.tes.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product addProduct(ProductRequest request) {
    Product product = new Product();
    product.setName(request.getName());
    product.setPrice(request.getPrice());
    product.setStock(request.getStock());
    product.setCreatedAt(LocalDateTime.now());
    product.setCreatedBy("Admin");
    product.setUpdatedAt(LocalDateTime.now());
    product.setUpdatedBy("Admin");
    return productRepository.save(product);
  }

  public Product updateProduct(UUID productId, ProductRequest request) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    product.setName(request.getName());
    product.setPrice(request.getPrice());
    product.setStock(request.getStock());
    product.setCreatedAt(LocalDateTime.now());
    product.setCreatedBy("Admin");
    product.setUpdatedAt(LocalDateTime.now());
    product.setUpdatedBy("Admin");
    return productRepository.save(product);
  }

  public void deleteProduct(UUID productId) {
    productRepository.deleteById(productId);
  }
}
