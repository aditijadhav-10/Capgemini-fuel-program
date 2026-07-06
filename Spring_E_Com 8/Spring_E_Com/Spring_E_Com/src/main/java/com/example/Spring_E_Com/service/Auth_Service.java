package com.example.Spring_E_Com.service;


import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.auth.LoginResponseDTO;
import com.example.Spring_E_Com.dto.auth.RegisterResponceDTO;

public interface Auth_Service {

    //RegisterResponceDTO saveCustomer(Customer customer);

    RegisterResponceDTO register(RegisterRequestDTO registerRequestDTO);

    // LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

  //  Customer updateCustomer(Long id, Customer customer);

    RegisterResponceDTO getRegisterData(String email);

   // List<Customer> getAllCustomers();

    String deleteUser(Long id);
}