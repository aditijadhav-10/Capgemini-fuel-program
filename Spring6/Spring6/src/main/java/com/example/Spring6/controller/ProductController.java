package com.example.Spring6.controller;

import com.example.Spring6.model.Product;
import com.example.Spring6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;



    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return productService.getProduct( id);
    }

    @PutMapping("/{id}")
    public Product put(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "id deleted successfully"+id;
    }

}
