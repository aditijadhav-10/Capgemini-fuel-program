package com.example.Spring_E_Com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@Table(name = "roles", uniqueConstraints={@UniqueConstraint(columnNames = "name")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;
    @Column(length = 200)
    private String description;
}
