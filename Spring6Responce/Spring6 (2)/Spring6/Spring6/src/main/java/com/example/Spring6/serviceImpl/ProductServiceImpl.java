package com.example.Spring6.serviceImpl;

import com.example.Spring6.DTO.ProductRequestDTO;
import com.example.Spring6.DTO.ProductResponceDTO;
import com.example.Spring6.exception.ProductNotFoundException;
import com.example.Spring6.model.Product;
import com.example.Spring6.repository.ProductRepo;
import com.example.Spring6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ProductResponceDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product product=new Product();

        product.setPname(productRequestDTO.getPname());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setPassword(productRequestDTO.getPassword());

        Product saveProduct=productRepo.save(product);
        ProductResponceDTO productResponceDTO=new ProductResponceDTO(product);

        productResponceDTO.setId(product.getId());
        productResponceDTO.setPname(saveProduct.getPname());
        productResponceDTO.setPrice(saveProduct.getPrice());
        productResponceDTO.setQuantity(saveProduct.getQuantity());

        //productResponceDTO.setPassword(passwordEncoder.encode(product.getPassword()));
        return productResponceDTO;
//      productRequestDTO.setPassword(passwordEncoder.encode(product.getPassword()));
//      return productRepo.save(product);

    }

    @Override
    public ProductResponceDTO getProduct(Long id) {

        // productRepo.findProductById(id).orElse(null);
        Product product=productRepo.findProductById(id).orElseThrow( ()->new RuntimeException("The Product is not found :"+id));

        ProductResponceDTO  dto =new ProductResponceDTO(product);

        dto.setPname(product.getPname());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());

        return dto;

    }

    @Override
    public List<ProductResponceDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public String deleteProduct(Long id) {
        Product product=productRepo.findProductById(id).orElseThrow( ()->new ProductNotFoundException("------ Id id not Found ----- "));
        productRepo.deleteById(id);
        return "The Data is deleted Successfully :"+id;
    }

    @Override
    public List<ProductResponceDTO> getAllProduct(Product product, Long id) {
        return List.of();
    }

    @Override
    public ProductResponceDTO updateProduct(ProductRequestDTO productRequestDTO, Long id) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));


        product.setPname(productRequestDTO.getPname());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());

        // for password
        product.setPassword(
                passwordEncoder.encode(productRequestDTO.getPassword())
        );

        Product updatedProduct = productRepo.save(product);

        ProductResponceDTO dto = new ProductResponceDTO(updatedProduct);

        dto.setId(updatedProduct.getId());
        dto.setPname(updatedProduct.getPname());
        dto.setPrice(updatedProduct.getPrice());
        dto.setQuantity(updatedProduct.getQuantity());

        return dto;
    }

}