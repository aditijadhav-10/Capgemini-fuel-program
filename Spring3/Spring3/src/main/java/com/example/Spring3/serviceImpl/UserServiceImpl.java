package com.example.Spring3.serviceImpl;

import com.example.Spring3.model.Employee;
import com.example.Spring3.model.User;
import com.example.Spring3.repository.UserRepo;
import com.example.Spring3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User getAllUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateuser(Long id) {
        return null;
    }
}
