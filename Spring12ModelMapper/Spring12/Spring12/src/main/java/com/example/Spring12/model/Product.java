package com.example.Spring12.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

//    @Column(name = "name")
    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    private String pname;

    @Column
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Password is required")
    @Size(min = 7, max = 70, message = "Password must be between 8 and 20 characters")

//    @Pattern(
//            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
//            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
//    )
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password.trim();
    }

}
