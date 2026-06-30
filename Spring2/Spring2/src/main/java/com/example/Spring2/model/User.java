package com.example.Spring2.model;

import jakarta.persistence.*;
@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User  extends BaseEntity{

    private String name;
    private String email;
    private String password;
    private String adderess;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdderess() {
        return adderess;
    }

    public void setAdderess(String adderess) {
        this.adderess = adderess;
    }
    public User() {

    }
    public User( String name, String email, String password, String adderess) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.adderess = adderess;
    }
}
