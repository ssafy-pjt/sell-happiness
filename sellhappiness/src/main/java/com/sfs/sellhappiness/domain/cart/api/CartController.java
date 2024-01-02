package com.sfs.sellhappiness.domain.cart.api;

import com.sfs.sellhappiness.domain.cart.application.CartService;
import com.sfs.sellhappiness.domain.cart.dto.req.AddCartReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("")
    public void addCart(@RequestBody AddCartReqDto cartItems) {
        cartService.addCart(cartItems);
    }
}
