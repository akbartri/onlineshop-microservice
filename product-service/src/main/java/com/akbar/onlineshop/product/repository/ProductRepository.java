package com.akbar.onlineshop.product.repository;

import com.akbar.onlineshop.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
