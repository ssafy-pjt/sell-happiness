package com.sfs.sellhappiness.domain.items.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "Option_Item")
public class OptionItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_item_id")
    private Long Id;

    private int price;
    private int stockNumber;

    @OneToMany
    @JoinColumn(name = "option_item_id")
    private List<Option> options = new ArrayList<>();

    @Builder
    public OptionItem(int price, int stockNumber){
        this.price = price;
        this.stockNumber = stockNumber;
    }

}
