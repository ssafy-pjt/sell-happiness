package com.sfs.sellhappiness.domain.items.dto;

import com.sfs.sellhappiness.domain.items.domain.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemFormDto {

    private Long Id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String name;

//    @NotNull(message = "재고는 필수 입력 값입니다.")
//    private int stockNumber;

    @NotBlank(message = "상세 내용은 필수 입력 값입니다.")
    private String itemDetail;

    private String itemSellStatus;

    @Builder
    public ItemFormDto(String name, String itemDetail, String itemSellStatus) {
        this.name = name;
        this.itemDetail = itemDetail;
        this.itemSellStatus = itemSellStatus;
    }

    public Item toEntity(ItemFormDto dto) {
        Item entity = Item.builder()
                .itemName(dto.name)
                .itemDetail(dto.itemDetail)
                .itemSellStatus(dto.itemSellStatus)
                .build();

        return entity;
    }
}
