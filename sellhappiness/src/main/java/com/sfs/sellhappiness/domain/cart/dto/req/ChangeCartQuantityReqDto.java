package com.sfs.sellhappiness.domain.cart.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChangeCartQuantityReqDto {
    private Long memberId;
    private Long productId;
    private Long productItemId;
    private Integer quantity;
}
