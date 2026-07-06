package com.example.Spring_E_COM.repository;

import com.example.Spring_E_COM.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}