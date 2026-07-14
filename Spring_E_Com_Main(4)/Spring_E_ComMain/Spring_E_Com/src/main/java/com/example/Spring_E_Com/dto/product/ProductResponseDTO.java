package com.example.Spring_E_Com.dto.product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private String productName;

    private String description;

    private Double price;

    private Integer stock;

    private String brand;

    private String category;

    private String imageUrl;

    private Long sellerId;

    private String sellerName;

}