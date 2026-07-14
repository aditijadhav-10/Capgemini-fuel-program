package com.example.Spring_E_Com.service;

public interface EmailService {
    boolean sendRegisterEmail(String to,String name);

    boolean sendLoginEmail(String to,String role);

}
