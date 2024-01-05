package com.sfs.sellhappiness.domain.product.domain;

import com.sfs.sellhappiness.domain.items.domain.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_img")
@Getter @Setter
public class ProductImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_img_id")
    private Long id;

    private String imgName; // 이미지 파일명

    private String oriImgName;

    private String imgUrl;

    private String repimgYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public void updateProductImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}
