package com.example.Spring_E_Com.dto.auth.Responce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String email;
    private String password;
    private String role;

    public LoginResponseDTO()
    {

    }

}
