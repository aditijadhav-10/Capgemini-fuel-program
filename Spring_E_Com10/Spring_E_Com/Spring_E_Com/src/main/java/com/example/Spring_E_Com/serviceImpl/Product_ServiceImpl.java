package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.model.Product;
import com.example.Spring_E_Com.repository.ProductRepository;
import com.example.Spring_E_Com.service.Product_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Product_ServiceImpl implements Product_Service {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    // For inserting the data into the product data
    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product product = modelMapper.map(productRequestDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponseDTO.class);

    }
}