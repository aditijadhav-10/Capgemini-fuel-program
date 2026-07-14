package com.example.Spring_E_Com.dto.role;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponceDTO {

    private  Long id;
    private String name;
    private String description;
}
