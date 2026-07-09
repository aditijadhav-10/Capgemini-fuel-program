package com.example.Spring_E_Com.dto.Role;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponseDTO {
    private Long id;
    private String name;
    private String description;
}
