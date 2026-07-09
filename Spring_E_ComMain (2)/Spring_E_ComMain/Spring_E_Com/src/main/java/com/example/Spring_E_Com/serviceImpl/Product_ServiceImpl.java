package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.exception.ResourceNotFound;
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


    // for getting the product data
    @Override
    public ProductResponseDTO getBYId(Long id) {
        Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFound("---- Product not Found Exception ---- "));
        ProductResponseDTO dto=modelMapper.map(product,ProductResponseDTO.class);
        return dto;
    }

    @Override
    public List<ProductResponseDTO> getAll() {

        return null;
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found"));

        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setBrand(dto.getBrand());
        product.setCategory(dto.getCategory());
        product.setImageUrl(dto.getImageUrl());

        Product updated = productRepository.save(product);

        return modelMapper.map(updated, ProductResponseDTO.class);
    }

    @Override
    public String delete(Long id) {

        Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFound(" -- Product not Found -- "));
        productRepository.delete(product);
        return "ID  is deleted Successfulyy ......"+id;

    }
}