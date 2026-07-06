package com.example.Spring6.controller;

import com.example.Spring6.DTO.ProductRequestDTO;
import com.example.Spring6.DTO.ProductResponseDTO;
import com.example.Spring6.model.Product;
import com.example.Spring6.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    // Old Method

    //@PostMapping
    //public ProductResponseDTO create(@RequestBody ProductRequestDTO requestDTO)
    //{
      //  return productService.saveProduct(requestDTO);
    //}

    // New Method
    @PostMapping
    public ResponseEntity<ProductResponseDTO>CreateProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO savedProduct = productService.saveProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // Old Method
    //@GetMapping("/{id}")
    //public ProductResponseDTO get(@PathVariable Long id) {
       // return productService.getProduct( id);
       //}

    // New Method
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO>getProduct(@PathVariable Long id){
       return ResponseEntity.ok(productService.getProduct(id));
    }


     // old method
    //@PutMapping("/{id}")
    //public ProductResponseDTO put(@RequestBody Product product, @PathVariable Long id) {
      //  return productService.updateProduct(product,id);
    //}

    //new method
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @Valid @RequestBody ProductRequestDTO productRequestDTO,
            @PathVariable Long id) {

        ProductResponseDTO updatedProduct =
                productService.updateProduct(productRequestDTO, id);

        return ResponseEntity.ok(updatedProduct);
    }

    //old method

    //@DeleteMapping("{id}")
   // public String delete(@PathVariable Long id) {
     //   productService.deleteProduct(id);
       // return "id deleted successfully"+id;
    //}

    //new method
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok("Product deleted successfully with id: " + id);
    }

}
