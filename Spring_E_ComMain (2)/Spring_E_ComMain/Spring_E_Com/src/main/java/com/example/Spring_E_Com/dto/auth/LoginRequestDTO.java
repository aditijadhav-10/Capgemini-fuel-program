package com.example.Spring_E_Com.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    @Size(max = 100,message = "Email cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=8,max = 20,message = "Password must be between 8 to 20 characters")
    private String password;

    public LoginRequestDTO()
    {

    }

//    public LoginRequestDTO(User user) {
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//    }
}
