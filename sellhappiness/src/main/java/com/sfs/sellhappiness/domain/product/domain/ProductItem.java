package com.sfs.sellhappiness.domain.product.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_item")
public class ProductItem { // OptionProduct로 수정?
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_item_id")
    private Long productItemId;

    @Column(name = "price")
    private Integer price; // TODO: INT VS INTEGER

    @Column(name = "stockNumber")
    private Integer stockNumber;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @OneToMany
    @JoinColumn(name = "product_item_id")
    private List<Option> options = new ArrayList<>();
}
