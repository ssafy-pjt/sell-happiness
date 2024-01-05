package com.sfs.sellhappiness.domain.product.domain;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "option")
public class Option {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;

    @Column(name = "option_type")
    private Integer optionType; // 0, 1

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "option_value")
    private String optionValue;

    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @Builder
    public Option(String option_name, String option_value, int option_type ) {
        this.optionName = option_name;
        this.optionValue = option_value;
        this.optionType = option_type;
    }
}
