package com.example.Spring3.controller;

import com.example.Spring3.model.Employee;
import com.example.Spring3.model.User;
import com.example.Spring3.service.UserService;
import com.example.Spring3.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl UserService;
    @Autowired
    private UserService userService;

    @PostMapping
    public User createData(@RequestBody User user)
    {
        return  UserService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public String getDelete(@PathVariable Long id)
    {
         userService.deleteUser(id);
         return "The Employee data is Deleted Successfully :"+id;

    }

    @GetMapping("/{id}")
    public Employee getData(@PathVariable Long id)
    {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public Employee getUpdate(@RequestBody User user,@PathVariable Long id)
    {
        user.setId(Math.toIntExact(id));
        return userService.saveUser(user);
    }



}
