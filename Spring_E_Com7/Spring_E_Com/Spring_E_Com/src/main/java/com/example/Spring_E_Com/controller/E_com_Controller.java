package com.example.Spring_E_Com.controller;


import com.example.Spring_E_Com.dto.request.LoginRequestDTO;
import com.example.Spring_E_Com.dto.request.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.response.LoginResponseDTO;
import com.example.Spring_E_Com.dto.response.RegisterResponceDTO;
import com.example.Spring_E_Com.model.Customer;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.service.E_Com_Service;
import com.example.Spring_E_Com.serviceImpl.E_Com_ServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class E_com_Controller {

    @Autowired
    private E_Com_ServiceImpl e_com_serviceImpl;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponceDTO> saveRegidster(@Valid  @RequestBody RegisterRequestDTO registerRequestDTO) {

        RegisterResponceDTO saveRegister = e_com_serviceImpl.register(registerRequestDTO);

        return  ResponseEntity.status(HttpStatus.CREATED).body(saveRegister);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> saveLogin(@Valid @RequestBody LoginRequestDTO loginRequestDTO)
    {
        LoginResponseDTO saveLogin =e_com_serviceImpl.login(loginRequestDTO);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(saveLogin);
    }


    @GetMapping("/{email}")
    public ResponseEntity<RegisterResponceDTO> getCustomer(@PathVariable String email) {

        return ResponseEntity.ok(e_com_serviceImpl.getRegisterData(email));
    }


//    @GetMapping
//    public ResponseEntity<List<Customer>> getAllCustomer() {
//
//        List<Customer> customers = customerService.getAllCustomers();
//
//        return ResponseEntity.ok(customers);
//    }




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
//        customerService.deleteCustomer(id);
//
//        return "Customer deleted successfully."+id;
//    }
}