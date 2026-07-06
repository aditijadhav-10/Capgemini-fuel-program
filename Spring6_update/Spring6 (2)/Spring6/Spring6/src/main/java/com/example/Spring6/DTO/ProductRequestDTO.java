package com.example.Spring6.DTO;

import jakarta.validation.constraints.*;

public class ProductRequestDTO {

        @NotBlank(message = "Product name is required")
        @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
        private String pname;

        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be greater than 0")
        private Integer quantity;

        @NotNull(message = "Price is required")
        @DecimalMin(value = "1.0", message = "Price must be greater than 0")
        private Double price;

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
        private String password;

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
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

        public void setPassword(String password) {
            this.password = password == null ? null : password.trim();
        }
    }