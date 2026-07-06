package com.example.Spring12.DAO;

import com.example.Spring12.model.Product;

import java.util.List;

public interface ProductDAO {

    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void delete(Long id);
}