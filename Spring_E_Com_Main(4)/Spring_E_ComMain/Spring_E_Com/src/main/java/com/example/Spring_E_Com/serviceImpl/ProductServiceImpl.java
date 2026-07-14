package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.exception.ResourceNotFoundException;
import com.example.Spring_E_Com.model.Product;
import com.example.Spring_E_Com.repository.ProductRepository;
import com.example.Spring_E_Com.service.Product_Service;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductServiceImpl implements Product_Service {


    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

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
        Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("---- Product not Found Exception ---- "));
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
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

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

        Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" -- Product not Found -- "));
        productRepository.delete(product);
        return "ID  is deleted Successfulyy ......"+id;

    }
}