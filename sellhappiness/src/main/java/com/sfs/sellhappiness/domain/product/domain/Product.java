package com.sfs.sellhappiness.domain.product.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductItem> productItems = new ArrayList<>();
}
