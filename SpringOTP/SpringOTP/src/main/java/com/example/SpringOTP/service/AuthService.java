package com.example.SpringOTP.service;

import com.example.SpringOTP.dto.ApiResponse;
import com.example.SpringOTP.dto.SendOtpRequest;
import com.example.SpringOTP.dto.VerifyOtpRequest;

public interface AuthService {

    // Generate and send OTP to email
    ApiResponse sendOtp(SendOtpRequest request);

    // Verify the entered OTP
    ApiResponse verifyOtp(VerifyOtpRequest request);

}