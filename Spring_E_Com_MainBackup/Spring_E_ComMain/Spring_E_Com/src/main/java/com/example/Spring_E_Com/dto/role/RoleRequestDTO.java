package com.example.Spring_E_Com.dto.role;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class RoleRequestDTO {

    @Column(unique = true, nullable = false)
    private String name;
    @Column(length = 200)
    private String description;
}
