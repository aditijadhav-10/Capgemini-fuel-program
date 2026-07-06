package com.example.Spring_E_Com.serviceImpl;


import com.example.Spring_E_Com.model.Customer;
import com.example.Spring_E_Com.repository.CustomerRepository;
import com.example.Spring_E_Com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }





    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer exitingCus = customerRepository.findById(id).orElseThrow();

        exitingCus.setFirstName(customer.getFirstName());
        exitingCus.setLastName(customer.getLastName());
        exitingCus.setEmail(customer.getEmail());
        exitingCus.setPassword(customer.getPassword());
        exitingCus.setPhone(customer.getPhone());

        exitingCus.setGender(customer.getGender());
        exitingCus.setRating(customer.getRating());

        return customerRepository.save(exitingCus);

    }





    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }




    @Override
    public String deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
        return " ------ Customer Deleted Successfully -------- "+id;
    }


}