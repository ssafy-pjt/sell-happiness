package com.sfs.sellhappiness.domain.cart.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCartItemReqDto {
    private Long productOptionId;
    private Integer quantity;
}
