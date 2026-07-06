package com.example.Spring_E_COM.service;

import com.example.Spring_E_COM.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    String deleteCustomer(Long id);

}