package com.example.Spring_E_Com.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seller extends User{

    private String gstNumber ;
    private String shopName;
    private String businessAddress;

}
