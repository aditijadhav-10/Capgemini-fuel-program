package com.example.Spring_E_Com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "sellers")
public class Seller extends User{
    @NotBlank(message = "Shop Name is required Please Enter the Shop Name")
    @Size(min = 3,max = 50,message = "The size is between 3 and 50 ")
    private String shopName;

    @NotBlank(message = "GST Number is required Please Enter GST Number ")
    @Size(min = 3,max = 50,message = "The size is between 3 and 50 ")
    private String gstNumber;

    @NotBlank(message = "Shop Address is required Please Enter the Shop Address")
    @Size(min = 3,max = 50,message = "The size is between 3 and 50 ")
    private String shopAddress;

}
