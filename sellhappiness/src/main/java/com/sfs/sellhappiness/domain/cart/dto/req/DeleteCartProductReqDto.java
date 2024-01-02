package com.sfs.sellhappiness.domain.cart.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeleteCartProductReqDto {
    private Long memberId;
    private Long productId;
}
