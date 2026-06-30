package com.example.Spring3.service;

import com.example.Spring3.model.User;

public interface UserService {
    public User saveUser(User user);

    User getUser(Long id);

    User getAllUser(User user);

    void deleteUser(Long id);

    User updateuser(Long id);
}
