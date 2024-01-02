package com.sfs.sellhappiness.domain.cart.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCartReqDto {
    private Long memberId;
    private Long productId;
    private List<AddCartReqOptionDto> options;
}
