package com.example.Spring6.repository;

import com.example.Spring6.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product ,Long> {
    Optional<Product> findProductById(Long id);


}
