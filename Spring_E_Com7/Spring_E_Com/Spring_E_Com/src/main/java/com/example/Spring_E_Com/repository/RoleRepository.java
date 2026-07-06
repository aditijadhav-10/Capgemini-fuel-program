package com.example.Spring_E_Com.repository;

import com.example.Spring_E_Com.model.Customer;
import com.example.Spring_E_Com.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role>findRoleBy(String name);
}
