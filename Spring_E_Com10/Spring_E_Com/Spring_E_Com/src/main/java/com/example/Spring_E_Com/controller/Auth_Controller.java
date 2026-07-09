package com.example.Spring_E_Com.controller;


import com.example.Spring_E_Com.dto.auth.Request.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.Request.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.auth.Responce.LoginResponseDTO;
import com.example.Spring_E_Com.dto.auth.Responce.RegisterResponceDTO;
import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.serviceImpl.Auth_ServiceImpl;
import com.example.Spring_E_Com.serviceImpl.Product_ServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class Auth_Controller {

    @Autowired
    private Auth_ServiceImpl authService;

    @Autowired
    private Product_ServiceImpl productService;




    // For the User
    @PostMapping("/register")
    public ResponseEntity<RegisterResponceDTO> saveRegidster(@Valid  @RequestBody RegisterRequestDTO registerRequestDTO) {

        RegisterResponceDTO saveRegister = authService.register(registerRequestDTO);

        return  ResponseEntity.status(HttpStatus.CREATED).body(saveRegister);
    }



    // For The creating the product data
    @PostMapping("/product")
    public ResponseEntity<ProductResponseDTO> saveProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO saveProduct= productService.saveProduct(productRequestDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }



    // for the login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> saveLogin(@Valid @RequestBody LoginRequestDTO loginRequestDTO)
    {
        LoginResponseDTO saveLogin =authService.login(loginRequestDTO);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(saveLogin);
    }


    @GetMapping("/{email}")
    public ResponseEntity<RegisterResponceDTO> getCustomer(@PathVariable String email) {

        return ResponseEntity.ok(authService.getRegisterData(email));
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllCustomer() {

        List<User> customers = authService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }




//    @PutMapping("/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer)
//    {
//
//        Customer updatedCustomer = customerService.updateCustomer(id, customer);
//        return ResponseEntity.ok(updatedCustomer);
//    }


//    @DeleteMapping("/{id}")
//    public String deleteCustomer(@PathVariable Long id) {
//
//        e_com_serviceImpl.deleteCustomer(id);
//
//        return "Customer deleted successfully."+id;
//    }

}