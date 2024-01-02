package com.sfs.sellhappiness.domain.cart.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CartItemsResDto {
    private Long cartItemId;
    private Long productId;
    private Integer quantity;
    private Long productItemId;
    private Long cartId;
    private Integer optionType;
    private Long optionId;
    private String optionName;
    private String optionValue;
}
