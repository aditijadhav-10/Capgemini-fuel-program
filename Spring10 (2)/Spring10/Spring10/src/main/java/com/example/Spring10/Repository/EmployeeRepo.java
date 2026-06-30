package com.example.Spring10.Repository;

import com.example.Spring10.model.Employee;
import com.example.Spring10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
