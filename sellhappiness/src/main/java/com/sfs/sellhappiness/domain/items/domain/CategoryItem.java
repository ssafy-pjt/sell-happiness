package com.sfs.sellhappiness.domain.items.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CategoryProduct {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_product_id")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

}
