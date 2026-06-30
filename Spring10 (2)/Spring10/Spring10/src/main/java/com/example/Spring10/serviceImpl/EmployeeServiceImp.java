package com.example.Spring10.serviceImpl;

import com.example.Spring10.Repository.EmployeeRepo;
import com.example.Spring10.model.Employee;
import com.example.Spring10.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    @Override
    public Employee getEmployee(Long id) {
        //return employeeRepo.findById(id).orElse(null);
        try{
            Optional<Employee> employee =employeeRepo.findById(id);
            if (employee.isPresent()){
                return employee.get();
            }
            throw new RuntimeException("user not found with id"+id);
        } catch (Exception e) {
            System.out.println("Service Error:"+e.getMessage());
            return null;
        }

    }
    @Override
    public Employee getAllEmployee(Employee emp) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);

    }

}
