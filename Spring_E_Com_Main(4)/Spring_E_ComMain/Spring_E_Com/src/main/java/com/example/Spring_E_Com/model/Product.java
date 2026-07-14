package com.example.Spring_E_Com.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity{

    @Column(nullable = false)
    private String productName;

    @Column(length = 3000)
    private String description;

    @Column(nullable = false)
    private Double price;

    private Integer stock;

    private String brand;

    private String category;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller_id;

}
