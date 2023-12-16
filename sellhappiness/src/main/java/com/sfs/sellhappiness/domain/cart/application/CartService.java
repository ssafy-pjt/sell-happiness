package com.sfs.sellhappiness.domain.cart.application;

import com.sfs.sellhappiness.domain.cart.dao.CartRepository;
import com.sfs.sellhappiness.domain.cart.domain.Cart;
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
    private final MemberRepository memberRepository;

    public void addCartItem(Long memberId, Long productId, List<AddCartItemReqDto> cartItemReqDtos) {
        Member member = memberRepository.findByMemberId(memberId).orElseThrow();;
        if (member.getCart() == null) {
            Cart cart = Cart.builder()
                    .member(member)
                    .build();
            cartRepository.save(cart);
            member.setCart(cart); // TODO: SETTER
            System.out.println("no cart");
        } else {
            Cart cart = member.getCart();
            System.out.println("exist cart");
        }
    }
}
