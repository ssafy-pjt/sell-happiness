package com.sfs.sellhappiness.domain.product.domain;

import com.sfs.sellhappiness.domain.items.domain.Item;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CategoryProduct {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_item_id")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

}
