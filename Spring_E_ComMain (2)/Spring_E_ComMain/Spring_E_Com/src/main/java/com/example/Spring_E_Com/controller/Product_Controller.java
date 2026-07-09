package com.example.Spring_E_Com.controller;

import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.model.Product;
import com.example.Spring_E_Com.serviceImpl.Product_ServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class Product_Controller {

    @Autowired
    private Product_ServiceImpl productService;

    // For The creating the product data
    @PostMapping("/product")
    public ResponseEntity<ProductResponseDTO> saveProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO saveProduct= productService.saveProduct(productRequestDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> get(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.getBYId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateCustomer(@PathVariable Long id,@RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO update=productService.update(id,productRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);

    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        productService.delete(id);
        return "THe product id deleted succssfully :"+id;
    }


}
