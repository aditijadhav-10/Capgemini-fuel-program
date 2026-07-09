package com.example.Spring_E_Com.controller;

import com.example.Spring_E_Com.dto.auth.AuthResponseDTO;
import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.service.Auth_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class Auth_Controller {

    private final Auth_Service authService;

    // Register User
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @Valid @RequestBody RegisterRequestDTO registerRequestDTO) {

        AuthResponseDTO response = authService.register(registerRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Login User
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO loginRequestDTO) {

        AuthResponseDTO response = authService.login(loginRequestDTO);

        return ResponseEntity.ok(response);
    }
}