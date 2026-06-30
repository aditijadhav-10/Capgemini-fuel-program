package com.example.Spring3.repository;

import com.example.Spring3.model.Employee;
import com.example.Spring3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}