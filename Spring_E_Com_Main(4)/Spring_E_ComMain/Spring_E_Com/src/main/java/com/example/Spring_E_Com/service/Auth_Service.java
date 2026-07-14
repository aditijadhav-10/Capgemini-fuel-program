package com.example.Spring_E_Com.service;
import com.example.Spring_E_Com.dto.auth.AuthResponseDTO;
import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;

public interface Auth_Service {

    AuthResponseDTO register(RegisterRequestDTO registerRequestDTO);

    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);
}