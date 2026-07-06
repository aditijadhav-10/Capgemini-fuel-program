package com.example.Spring_E_Com.dto.response;

import com.example.Spring_E_Com.model.User;
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


//    public LoginResponseDTO(User user) {
//        this.email = user.getEmail();
//        this.password= user.getPassword();
//        this.role = String.valueOf(user.getRole());
//    }
}
