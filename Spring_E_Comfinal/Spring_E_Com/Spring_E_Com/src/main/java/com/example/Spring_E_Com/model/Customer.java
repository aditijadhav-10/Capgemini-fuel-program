package com.example.Spring_E_Com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends User {

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Double rating;

    public Customer() {
    }

    public Customer(String gender, Double rating) {
        this.gender = gender;
        this.rating = rating;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}