package com.sfs.sellhappiness.domain.product.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @NotNull
    private String productDetail; // 상품 상세 설명
    private String productSellStatus; // 상품 판매 상태

    @NotNull
    private String imgUrl;

    @CreationTimestamp // insert쿼리 발생시에 현재시간 값을 적용
    @Column(name = "product_reg_date")
    private LocalDateTime product_reg_date; // 상품 등록 시간

    @UpdateTimestamp // update쿼리 발생했을 때 현재시간 값을 적용
    @Column(name = "product_upd_date")
    private LocalDateTime product_upd_date; // 상품 수정 시간

    @OneToMany(mappedBy = "item")
    private List<CategoryProduct> categoryItems = new ArrayList<>();


    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductItem> productItems = new ArrayList<>();

    @Builder
    public Product (String productName, String productDetail, String productSellStatus, String imgUrl){
        this.productName = productName;
        this.productDetail = productDetail;
        this.productSellStatus = productSellStatus;
        this.imgUrl = imgUrl;
    }
}
