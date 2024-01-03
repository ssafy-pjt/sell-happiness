package com.sfs.sellhappiness.domain.items.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_img")
@Getter @Setter
public class ItemImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id")
    private Long id;

    private String imgName; // 이미지 파일명

    private String oriImgName;

    private String imgUrl;

    private String repimgYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}
