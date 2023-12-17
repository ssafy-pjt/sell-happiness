package com.sfs.sellhappiness.domain.cart.application;

import com.sfs.sellhappiness.domain.cart.dao.CartItemRepository;
import com.sfs.sellhappiness.domain.cart.dao.CartRepository;
import com.sfs.sellhappiness.domain.cart.domain.Cart;
import com.sfs.sellhappiness.domain.cart.domain.CartItem;
import com.sfs.sellhappiness.domain.cart.dto.req.AddCartItemReqDto;
import com.sfs.sellhappiness.domain.member.dao.MemberRepository;
import com.sfs.sellhappiness.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional // TODO: @Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;

    public void addCartItem(Long memberId, Long productId, List<AddCartItemReqDto> cartItemReqDtos) {
        Member member = memberRepository.findByMemberId(memberId).orElseThrow();
        Cart cart = null;
        if (member.getCart() == null) {
            cart = Cart.builder()
                    .member(member)
                    .build();
            cartRepository.save(cart);
            member.setCart(cart); // TODO: SETTER

            for (AddCartItemReqDto reqCartItem : cartItemReqDtos) {
                CartItem cartItem = CartItem.builder()
                        .productId(productId)
                        .productItemId(reqCartItem.getProductOptionId())
                        .quantity(reqCartItem.getQuantity())
                        .cart(cart)
                        .build();
                cartItemRepository.save(cartItem);
            }
            System.out.println("no cart");
        } else {
            cart = member.getCart();
            System.out.println("exist cart");
        }
    }
}
