package com.example.Spring_E_Com.service;


import com.example.Spring_E_Com.dto.auth.Request.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.Request.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.auth.Responce.LoginResponseDTO;
import com.example.Spring_E_Com.dto.auth.Responce.RegisterResponceDTO;
import com.example.Spring_E_Com.dto.product.ProductRequestDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.model.User;

import java.util.List;

public interface Auth_Service {

    //RegisterResponceDTO saveCustomer(Customer customer);

    RegisterResponceDTO register(RegisterRequestDTO registerRequestDTO);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    // Customer updateCustomer(Long id, Customer customer);

    RegisterResponceDTO getRegisterData(String email);

    List<User> getAllCustomers();

   //String deleteUser(Long id);
}