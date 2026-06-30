package com.example.Spring10.service;

import com.example.Spring10.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee emp);
    Employee getEmployee(Long id);
    Employee getAllEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    void deleteEmployee(Long id);
}
