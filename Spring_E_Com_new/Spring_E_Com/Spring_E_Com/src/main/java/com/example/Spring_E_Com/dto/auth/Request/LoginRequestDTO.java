package com.example.Spring_E_Com.dto.auth.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    private String email;
    private String password;

    public LoginRequestDTO()
    {

    }

//    public LoginRequestDTO(User user) {
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//    }
}
