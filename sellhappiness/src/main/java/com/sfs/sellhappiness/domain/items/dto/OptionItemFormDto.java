package com.sfs.sellhappiness.domain.items.dto;

import com.sfs.sellhappiness.domain.items.domain.OptionItem;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OptionItemFormDto {

    private Long id;
    private int price;
    private int stockNumber;

    @Builder
    public OptionItemFormDto(int price, int stockNumber){
        this.price = price;
        this.stockNumber = stockNumber;
    }

    public OptionItem toEntity(OptionItemFormDto dto){
        OptionItem entity = OptionItem.builder()
                .price(dto.price)
                .stockNumber(dto.stockNumber)
                .build();

                return entity;
    }

}
