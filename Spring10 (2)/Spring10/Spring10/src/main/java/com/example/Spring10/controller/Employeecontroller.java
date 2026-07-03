package com.example.Spring10.controller;

import com.example.Spring10.Repository.EmployeeRepo;
import com.example.Spring10.model.Employee;
import com.example.Spring10.model.User;
import com.example.Spring10.service.EmployeeService;
import com.example.Spring10.serviceImpl.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class Employeecontroller {
    @Autowired
    private EmployeeServiceImp employeeserviceImp;

    @Autowired
    private EmployeeRepo employeeRepo;
    @PostMapping
    public Employee createUser(@RequestBody Employee employee){
        return employeeserviceImp.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeserviceImp.getEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        employee.setId(id);
        return employeeserviceImp.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeserviceImp.deleteEmployee(id);
        return "Employee deleted successfully. ID : " + id;
    }
}
