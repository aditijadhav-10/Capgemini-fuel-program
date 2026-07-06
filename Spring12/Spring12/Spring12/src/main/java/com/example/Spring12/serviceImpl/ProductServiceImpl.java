package com.example.Spring12.serviceImpl;

import com.example.Spring12.DAO.ProductDAO;
import com.example.Spring12.DAO.ProductDAOImpl;
import com.example.Spring12.DTO.ProductRequestDTO;
import com.example.Spring12.DTO.ProductResponceDTO;
import com.example.Spring12.config.ModelMapperCofig;
import com.example.Spring12.exception.ProductNotFoundException;
import com.example.Spring12.model.Product;
import com.example.Spring12.repository.ProductRepo;
import com.example.Spring12.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private  ModelMapperCofig mapperCofig;

    @Autowired
    private ProductDAOImpl productDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public ProductResponceDTO saveProduct(ProductRequestDTO productRequestDTO) {
//
//        Product product = new Product();
//
//
//        product.prePersist();
//        product.preUpdate();
//
//
//
//        product.setPname(productRequestDTO.getPname());
//        product.setPrice(productRequestDTO.getPrice());
//        product.setQuantity(productRequestDTO.getQuantity());
//
//        // Encode password before saving
//        product.setPassword(passwordEncoder.encode(productRequestDTO.getPassword()));
//
//        Product saveProduct = productDAO.save(product);
//
//        ProductResponceDTO productResponceDTO = new ProductResponceDTO(saveProduct);
//
//        productResponceDTO.setId(saveProduct.getId());
//        productResponceDTO.setPname(saveProduct.getPname());
//        productResponceDTO.setPrice(saveProduct.getPrice());
//        productResponceDTO.setQuantity(saveProduct.getQuantity());
//
//        // productResponceDTO.setPassword(passwordEncoder.encode(product.getPassword()));
//        return productResponceDTO;
//
//        // productRequestDTO.setPassword(passwordEncoder.encode(product.getPassword()));
//        // return productRepo.save(product);
//    }





    @Autowired
    private ModelMapper modelMapper;@Override
    public ProductResponceDTO saveProduct(ProductRequestDTO productRequestDTO)
    {
        productRequestDTO.setPassword(productRequestDTO.getPassword().trim());

        Product product = modelMapper.map(productRequestDTO, Product.class);
        product.setPassword(passwordEncoder.encode(productRequestDTO.getPassword()));
        Product saveedProduct =productRepo.save(product);
        return modelMapper.map(saveedProduct, ProductResponceDTO.class);
    }







    @Override
    public ProductResponceDTO getProduct(Long id) {

//        Product product = productRepo.findById(id)
//                .orElseThrow(() ->
//                        new RuntimeException("The Product is not found : " + id));

        Product product = productDAO.findById(id);
        ProductResponceDTO dto = new ProductResponceDTO(product);

        dto.setId(product.getId());
        dto.setPname(product.getPname());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());

        return dto;
    }





    @Override
    public String deleteProduct(Long id) {

//        Product product = productRepo.findProductById(id)
//                .orElseThrow(() ->
//                        new ProductNotFoundException("Product Id not Found : " + id));

        Product product = productDAO.findById(id);

        productDAO.delete(id);

        return "The Data is deleted Successfully : " + id;
    }








    @Override
    public List<ProductResponceDTO> getAllProduct(Product product, Long id) {
        return List.of();
    }








    @Override
    public ProductResponceDTO updateProduct(ProductRequestDTO productRequestDTO, Long id) {

//        Product product = productRepo.findById(id)
//                .orElseThrow(() ->
//                        new ProductNotFoundException("Product not found with id: " + id));

        Product product = productDAO.findById(id);
                product.setPname(productRequestDTO.getPname());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());

        // Encode password before updating
        product.setPassword(passwordEncoder.encode(productRequestDTO.getPassword()));

        Product updatedProduct = productRepo.save(product);

        ProductResponceDTO dto = new ProductResponceDTO(updatedProduct);

        dto.setId(updatedProduct.getId());
        dto.setPname(updatedProduct.getPname());
        dto.setPrice(updatedProduct.getPrice());
        dto.setQuantity(updatedProduct.getQuantity());

        return dto;
    }
}