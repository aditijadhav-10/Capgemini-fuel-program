package com.example.Spring6.DTO;

import com.example.Spring6.model.Product;
import jakarta.validation.constraints.*;

public class ProductResponseDTO {
    private Long id;

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    private String pname;

    @NotNull(message = "Product quantity is required")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @NotNull(message = "Product price is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20)
    private String password;


    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.pname = product.getPname();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
