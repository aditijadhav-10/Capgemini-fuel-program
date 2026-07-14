package com.example.Spring_E_Com.dto.auth;

import com.example.Spring_E_Com.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
    private String role;


}