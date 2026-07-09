package com.example.Spring_E_Com.exception;

import com.example.Spring_E_Com.model.Role;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String message) {
        super(message);
    }
}
