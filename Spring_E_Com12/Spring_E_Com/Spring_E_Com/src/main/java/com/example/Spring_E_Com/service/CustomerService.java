package com.example.Spring_E_Com.service;


import com.example.Spring_E_Com.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    String deleteCustomer(Long id);
}