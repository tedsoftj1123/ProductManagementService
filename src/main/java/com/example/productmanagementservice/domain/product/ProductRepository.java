package com.example.productmanagementservice.domain.product;


import com.example.productmanagementservice.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProductName(String name);
}
