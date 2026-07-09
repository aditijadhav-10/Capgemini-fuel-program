package com.example.Spring_E_Com.dto.product;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class ProductRequestDTO {

        @NotBlank(message = "Product name is required")
        private String productName;

        private String description;

        @NotNull(message = "Price is required")
        @Min(value = 1, message = "Price must be greater than 0")
        private Double price;

        @NotNull(message = "Stock is required")
        @Min(value = 0, message = "Stock cannot be negative")
        private Integer stock;

        @NotBlank(message = "Brand is required")
        private String brand;

        @NotBlank(message = "Category is required")
        private String category;

        private String imageUrl;
    }

