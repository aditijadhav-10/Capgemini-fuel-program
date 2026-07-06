package com.example.Spring12.DTO;

import com.example.Spring12.model.Product;
import jakarta.validation.constraints.*;

public class ProductResponceDTO {

    private Long id;

    @NotBlank(message = "Product is must required ")
    @Size(min = 3,max=50,message = "Product name is must between the 3 to 50 ")
    private String pname;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Double price;



    public ProductResponceDTO(Product product)
    {
        this.id=product.getId();
        this.pname = product.getPname();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }
    public ProductResponceDTO()
    {

    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
