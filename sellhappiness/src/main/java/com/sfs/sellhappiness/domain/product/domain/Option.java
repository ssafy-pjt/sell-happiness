package com.sfs.sellhappiness.domain.product.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "option")
public class Option {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;

    @Column(name = "option_type")
    private Integer optionType; // TODO: INT VS INTEGER // 0, 1

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "option_value")
    private String optionValue;

    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;
}
