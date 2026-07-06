package com.example.Spring12.controller;

import com.example.Spring12.DTO.ProductRequestDTO;
import com.example.Spring12.DTO.ProductResponceDTO;
import com.example.Spring12.model.Product;
import com.example.Spring12.service.ProductService;
import com.example.Spring12.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;


    //Old method

//    @PostMapping
//    public ProductResponceDTO create(@RequestBody ProductRequestDTO productRequestDTO) {
//        return productService.saveProduct(productRequestDTO);
//    }


    // new method for the Post mapping
    @PostMapping
    public ResponseEntity<ProductResponceDTO> createdata(@RequestBody ProductRequestDTO productRequestDTO)
    {
        System.out.println("The password in producuctRequest DTO :"+productRequestDTO.getPassword());
        Product product=new Product();
        System.out.println("The Password in Product class :"+product.getPassword());

        ProductResponceDTO saveProduct=productService.saveProduct(productRequestDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    // Old Method

//    @GetMapping("/{id}")
//    public ProductResponceDTO getdata(@PathVariable Long id)
//    {
//        return productService.getProduct(id);
//    }



    // New Method
    @GetMapping("/{id}")
    public ResponseEntity <ProductResponceDTO> getData(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    // Old Method
//    @PutMapping("/{id}")
//    public ProductResponceDTO put(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable Long id) {
//        return productService.updateProduct(productRequestDTO,id);
//    }

    //New Method
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponceDTO> update(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable Long id)
    {


        return ResponseEntity.ok(productService.updateProduct(productRequestDTO,id));
    }

   @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
       return ResponseEntity.ok(productService.deleteProduct(id));

    }
}
