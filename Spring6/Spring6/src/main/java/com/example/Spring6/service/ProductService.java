package com.example.Spring6.service;


import com.example.Spring6.model.Product;

public interface ProductService {
    Product saveProduct(Product product);
    Product getProduct(Long id);
    Product updateProduct(Product product,Long id);
    void deleteProduct(Long id);
}
