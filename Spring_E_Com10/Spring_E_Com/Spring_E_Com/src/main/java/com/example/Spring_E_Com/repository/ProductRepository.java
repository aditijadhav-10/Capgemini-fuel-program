package com.example.Spring_E_Com.repository;

import com.example.Spring_E_Com.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
