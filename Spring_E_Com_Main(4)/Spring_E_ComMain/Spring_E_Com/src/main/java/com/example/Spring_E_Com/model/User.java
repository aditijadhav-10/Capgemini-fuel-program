package com.example.Spring_E_Com.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(name="uk_user_email",columnNames = "email")})
@Inheritance(strategy = InheritanceType.JOINED)

public class User extends BaseEntity {

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "is_email_verified", nullable = false)
    @Builder.Default
    private Boolean emailVerified = false;

    private Boolean accountNonLoacked=true;

    @Column(length = 15)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="role_id",nullable = false,foreignKey = @ForeignKey(name="fk_user_Table"))
    private Role role;

    private String token;

    private Boolean accountNonExpired=true;
    private  Boolean credentialNonExpired=true;

}