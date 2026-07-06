package com.example.Spring6.service;


import com.example.Spring6.DTO.ProductRequestDTO;
import com.example.Spring6.DTO.ProductResponceDTO;
import com.example.Spring6.model.Product;

import java.util.List;

public interface ProductService
{
    ProductResponceDTO saveProduct(ProductRequestDTO productRequestDTO);
    ProductResponceDTO getProduct(Long id);
    List<ProductResponceDTO> getAllProducts();
    public ProductResponceDTO updateProduct(ProductRequestDTO productRequestDTO,Long id);

    String deleteProduct(Long id);
}
