package com.example.Spring_E_Com.service;


import com.example.Spring_E_Com.dto.request.LoginRequestDTO;
import com.example.Spring_E_Com.dto.request.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.response.LoginResponseDTO;
import com.example.Spring_E_Com.dto.response.RegisterResponceDTO;
import com.example.Spring_E_Com.model.Customer;

import java.util.List;

public interface E_Com_Service {

    //RegisterResponceDTO saveCustomer(Customer customer);

    RegisterResponceDTO register(RegisterRequestDTO registerRequestDTO);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

  //  Customer updateCustomer(Long id, Customer customer);

    RegisterResponceDTO getRegisterData(String email);

   // List<Customer> getAllCustomers();

   // String deleteCustomer(Long id);
}