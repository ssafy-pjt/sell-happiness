package com.sfs.sellhappiness.domain.items.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CategoryItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_item_id")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "item_id")
    Item item;

}
