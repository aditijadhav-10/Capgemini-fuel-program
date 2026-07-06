package com.example.Spring6.DTO;

import com.example.Spring6.model.Product;

public class ProductResponceDTO {

    private Long id;
    private String pname;
    private int quantity;
    private double price;



    public ProductResponceDTO(Product product) {
        this.id=product.getId();
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

    public ProductResponceDTO()
    {

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
