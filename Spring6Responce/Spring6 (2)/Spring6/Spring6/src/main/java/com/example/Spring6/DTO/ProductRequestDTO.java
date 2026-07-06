package com.example.Spring6.DTO;

import com.example.Spring6.model.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

    @NotBlank
    private String pname;

    @NotNull
    @Min(1)
    private int quantity;

    @NotNull
    @DecimalMin("1.0")
    private double price;
    private String password;

    public ProductRequestDTO(Product product) {

        this.pname = product.getPname();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.password = product.getPassword();
    }


    public ProductRequestDTO()
    {}
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
