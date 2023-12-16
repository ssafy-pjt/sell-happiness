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
        Long productId = 0L;
        List<AddCartItemReqDto> cartItemReqDtos = new ArrayList<>();
        AddCartItemReqDto cartItem1 = AddCartItemReqDto.builder()
                .productOptionId(0L)
                .quantity(1)
                .build();
        AddCartItemReqDto cartItem2 = AddCartItemReqDto.builder()
                .productOptionId(1L)
                .quantity(1)
                .build();
        cartItemReqDtos.add(cartItem1);
        cartItemReqDtos.add(cartItem2);

        cartService.addCartItem(memberId, productId, cartItemReqDtos);
    }
}
