package com.example.Spring6.serviceImpl;

import com.example.Spring6.DTO.ProductRequestDTO;
import com.example.Spring6.DTO.ProductResponseDTO;
import com.example.Spring6.model.Product;
import com.example.Spring6.repository.ProductRepo;
import com.example.Spring6.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

   //@Autowired
   //private ProductRepo productRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //@Autowired
    //private ModelMapper modelMapper;

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo,
                              ModelMapper modelMapper,
                              PasswordEncoder passwordEncoder) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


   // @Override
    //public Product saveProduct(Product product) {
    // product.setPassword(passwordEncoder.encode(product.getPassword()));
    // return productRepo.save(product);}

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO requestDTO) {
        Product product = new Product();
        product.setPname(requestDTO.getPname());
        product.setPrice(requestDTO.getPrice());
        product.setQuantity(requestDTO.getQuantity());
        product.setPassword(requestDTO.getPassword());

        Product savedProduct=productRepo.save(product);
        ProductResponseDTO responceDTO=new ProductResponseDTO(product);

        responceDTO.setId(savedProduct.getId());
        responceDTO.setPname(savedProduct.getPname());
        responceDTO.setPrice(savedProduct.getPrice());
        responceDTO.setQuantity(savedProduct.getQuantity());

        return responceDTO;

    }


    @Override
    public ProductResponseDTO getProduct(Long id) {
        //return productRepo.findProductById(id)
                //.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));



        ProductResponseDTO responseDTO = new ProductResponseDTO(product);
        responseDTO.setId(product.getId());
        responseDTO.setPname(product.getPname());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setQuantity(product.getQuantity());

        return responseDTO;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setPname(productRequestDTO.getPname());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setPassword(productRequestDTO.getPassword());

        Product updatedProduct = productRepo.save(product);

        ProductResponseDTO responseDTO = new ProductResponseDTO(product);
        responseDTO.setId(updatedProduct.getId());
        responseDTO.setPname(updatedProduct.getPname());
        responseDTO.setPrice(updatedProduct.getPrice());

        return responseDTO;
    }

    //@Override
    //public ProductResponseDTO updateProduct(Product product, Long id) {
      //   Product existingProduct = productRepo.findById(id)
             //   .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        //existingProduct.setPname(product.getPname());
        //existingProduct.setQuantity(product.getQuantity());
        //existingProduct.setPrice(product.getPrice());
       // existingProduct.setPassword(passwordEncoder.encode(product.getPassword()));

       // return new ProductResponseDTO(product);
    //}

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        productRepo.delete(product);
    }
}