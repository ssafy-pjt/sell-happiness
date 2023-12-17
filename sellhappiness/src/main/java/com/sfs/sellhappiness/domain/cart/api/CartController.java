package com.sfs.sellhappiness.domain.cart.api;

import com.sfs.sellhappiness.domain.cart.application.CartService;
import com.sfs.sellhappiness.domain.cart.dto.req.AddCartItemReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("")
    public void addCartItem() {
        Long memberId = 0L;
        Long productId = 1L;
        List<AddCartItemReqDto> cartItemReqDtos = new ArrayList<>();
//        AddCartItemReqDto cartItem1 = AddCartItemReqDto.builder()
//                .productOptionId(0L) // 이미 존재하는 상품 + 이미 존재하는 옵션 : 수량만 증가
//                .quantity(1)
//                .build();
//        cartItemReqDtos.add(cartItem1);

        // 이미 존재하는 상품 + 새로운 옵션 : 새로 추가
//        AddCartItemReqDto cartItem2 = AddCartItemReqDto.builder()
//                .productOptionId(2L)
//                .quantity(1)
//                .build();
//        cartItemReqDtos.add(cartItem2);

        // 새로운 상품
        AddCartItemReqDto cartItem3 = AddCartItemReqDto.builder()
                .productOptionId(3L) // 이미 존재하는 상품 + 이미 존재하는 옵션 : 수량만 증가
                .quantity(1)
                .build();
        cartItemReqDtos.add(cartItem3);

        cartService.addCartItem(memberId, productId, cartItemReqDtos);
    }
}
