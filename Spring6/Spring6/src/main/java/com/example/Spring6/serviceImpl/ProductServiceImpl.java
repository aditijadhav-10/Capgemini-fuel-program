package com.example.Spring6.serviceImpl;

import com.example.Spring6.model.Product;
import com.example.Spring6.repository.ProductRepo;
import com.example.Spring6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Product saveProduct(Product product) {
        product.setPassword(passwordEncoder.encode(product.getPassword()));
        return productRepo.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setPname(product.getPname());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPassword(passwordEncoder.encode(product.getPassword()));

        return productRepo.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}