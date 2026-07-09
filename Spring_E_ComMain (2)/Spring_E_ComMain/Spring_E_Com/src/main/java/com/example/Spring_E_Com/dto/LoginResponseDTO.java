package com.example.Spring_E_Com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String email;
    private String password;
    private String role;
    private String message;

    public LoginResponseDTO()
    {

    }

    public static class AuthResponceDto {
    }
}
