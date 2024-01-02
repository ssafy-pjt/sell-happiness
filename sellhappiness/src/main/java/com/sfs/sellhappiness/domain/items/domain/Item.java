package com.sfs.sellhappiness.domain.items.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Table(name = "Items")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long Id;

    @NotNull
    @Column(name = "item_name")
    private String itemName;

    @NotNull
    private String itemDetail; // 상품 상세 설명
    private String itemSellStatus; // 상품 판매 상태

    @CreationTimestamp // insert쿼리 발생시에 현재시간 값을 적용
    @Column(name = "item_reg_date")
    private LocalDateTime item_reg_date; // 상품 등록 시간

    @UpdateTimestamp // update쿼리 발생했을 때 현재시간 값을 적용
    @Column(name = "item_upd_date")
    private LocalDateTime item_upd_date; // 상품 수정 시간

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItems = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private List<OptionItem> optionItems = new ArrayList<>();

    // 생성자에 Builder 적용
    @Builder
    public Item (String itemName, String itemDetail, String itemSellStatus){
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemSellStatus = itemSellStatus;
    }

}
