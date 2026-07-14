package com.example.SpringOTP.service;

public interface EmailService {

    void sendOtpEmail(String toEmail, String otp);

}