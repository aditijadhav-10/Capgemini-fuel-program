package com.example.Spring_E_Com.model;
import com.example.Spring_E_Com.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customers")
public class Customer extends User {

    @NotBlank(message = "Gender is required Please Enter the Gender ")
    @Size(min = 3,max = 50,message = "The size is between 3 and 50 ")
    private String gender;


    private double rating;

    public Customer() {
    }

    public Customer(String gender, double rating) {
        this.gender = gender;
        this.rating = rating;
    }
}