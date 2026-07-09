package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.exception.ProductNotFoundException;
import com.example.Spring_E_Com.model.Product;
import com.example.Spring_E_Com.repository.ProductRepository;
import com.example.Spring_E_Com.service.Product_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ProductResponseDTO getBYId(Long id) {
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("---- Product not Found Exception ---- "));
        ProductResponseDTO dto=modelMapper.map(product,ProductResponseDTO.class);
        return dto;
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
        ProductResponseDTO dto1=modelMapper.map(product,ProductResponseDTO.class);
        Product updateProduct=productRepository.save(product);
        return modelMapper.map(updateProduct, ProductResponseDTO.class);


    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id : " + id));
        productRepository.delete(product);


    }
}