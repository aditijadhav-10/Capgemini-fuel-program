package com.example.Spring_E_Com.dto.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleRequestDTO {
    @NotBlank(message = "Role name is required")
    private String name;

    private String description;
}
