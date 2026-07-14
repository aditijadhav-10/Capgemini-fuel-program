package com.example.Spring_E_Com.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "Email is Required")
    @Email(message = "please enter a valide eamil address")
    @Size(max = 100,message = "Email cannot exceed 100 character")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8,max = 20,message = "Password muct be between 8 and 20 character ")
    private String password;

}
