package com.example.Spring12.service;


import com.example.Spring12.DTO.ProductRequestDTO;
import com.example.Spring12.DTO.ProductResponceDTO;
import com.example.Spring12.model.Product;

import java.util.List;

public interface ProductService {
    ProductResponceDTO saveProduct(ProductRequestDTO productRequestDTO);
    ProductResponceDTO getProduct(Long id);
    List<ProductResponceDTO> getAllProduct(Product product,Long id);
    public ProductResponceDTO updateProduct(ProductRequestDTO productRequestDTO,Long id);

    String deleteProduct(Long id);
}
