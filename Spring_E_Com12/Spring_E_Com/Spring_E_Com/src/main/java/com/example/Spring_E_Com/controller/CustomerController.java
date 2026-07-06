package com.example.Spring_E_Com.controller;


import com.example.Spring_E_Com.model.Customer;
import com.example.Spring_E_Com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.saveCustomer(customer);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {

        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {

        List<Customer> customers = customerService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer)
    {

        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }




    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);

        return "Customer deleted successfully."+id;
    }
}