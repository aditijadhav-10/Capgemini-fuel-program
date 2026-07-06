package com.example.Spring_E_Com.model;
import com.example.Spring_E_Com.model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends User {
    private String gender;

    private double rating;

    public Customer() {
    }

    public Customer(String gender, double rating) {
        this.gender = gender;
        this.rating = rating;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}