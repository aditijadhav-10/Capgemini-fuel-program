package com.example.Spring12.repository;

import com.example.Spring12.DTO.ProductRequestDTO;
import com.example.Spring12.DTO.ProductResponceDTO;
import com.example.Spring12.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product ,Long> {
    Optional<Product> findProductById(Long id);
    //Optional<ProductResponceDTO> finProductResponceID(Long id);


}
