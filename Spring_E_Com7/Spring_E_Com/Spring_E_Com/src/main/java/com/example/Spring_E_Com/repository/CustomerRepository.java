package com.example.Spring_E_Com.repository;


import com.example.Spring_E_Com.dto.response.RegisterResponceDTO;
import com.example.Spring_E_Com.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}