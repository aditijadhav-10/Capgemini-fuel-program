package com.example.Spring_E_Com.dto.request;

import com.example.Spring_E_Com.model.User;
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
