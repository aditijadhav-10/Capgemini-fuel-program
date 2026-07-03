package com.example.Spring6.service;


import com.example.Spring6.DTO.ProductRequestDTO;
import com.example.Spring6.DTO.ProductResponseDTO;
import com.example.Spring6.model.Product;

public interface ProductService {
    ProductResponseDTO saveProduct(ProductRequestDTO requestDTO);
    ProductResponseDTO getProduct(Long id);
    ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, Long id);
    void deleteProduct(Long id);
}
