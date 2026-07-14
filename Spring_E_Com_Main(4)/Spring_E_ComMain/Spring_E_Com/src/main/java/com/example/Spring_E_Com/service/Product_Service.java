package com.example.Spring_E_Com.service;

import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;

import java.util.List;

public interface Product_Service {


    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO getBYId(Long id);
    List<ProductResponseDTO> getAll();
    ProductResponseDTO update(Long  id,ProductRequestDTO dto);
    String delete(Long id);


}
