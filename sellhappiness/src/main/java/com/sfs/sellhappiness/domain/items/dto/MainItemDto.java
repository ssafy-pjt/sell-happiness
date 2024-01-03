package com.sfs.sellhappiness.domain.items.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.internal.compiler.batch.Main;

@Getter
@Setter
public class MainItemDto {

    private Long id;

    private String itemName;
    private String itemDetail;
    private String imgUrl;
    private int price;
    private int stockNumber;

    @QueryProjection
    public MainItemDto(Long id, String itemName, String itemDetail, String imgUrl, int price, int stockNumber){
        this.id = id;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.imgUrl = imgUrl;
        this.price = price;
        this.stockNumber = stockNumber;
    }
}
