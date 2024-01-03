package com.sfs.sellhappiness.domain.cart.application;

import com.sfs.sellhappiness.domain.cart.dao.CartRepository;
import com.sfs.sellhappiness.domain.cart.domain.Cart;
import com.sfs.sellhappiness.domain.cart.dto.req.*;
import com.sfs.sellhappiness.domain.cart.dto.res.CartItemsResInterface;
import com.sfs.sellhappiness.domain.member.dao.MemberRepository;
import com.sfs.sellhappiness.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional // TODO: @Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;

    // 장바구니에 상품 추가
    public void addCart(AddCartReqDto cartItems) {
        // cartItems의 options를 반복하면서
        // if (memberId, productId, productItemId가 존재한다면) 수량만 증가
        // else 새로 추가

        Long memberId = cartItems.getMemberId();
        Long productId = cartItems.getProductId();
        List<AddCartReqOptionDto> options = cartItems.getOptions();

        // member의 carts 조회
        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Cart> carts = member.getCarts();
        for (AddCartReqOptionDto option : options) {
            boolean isOptionExist = false;
            for (Cart cart : carts) {
                // if (cart의 productId == productId && cart의 productItemId == option의 productItemId) 수량만 증가
                if (Objects.equals(cart.getProductId(), productId) && Objects.equals(cart.getProductItemId(), option.getProductItemId())) {
                    cart.setQuantity(cart.getQuantity() + option.getQuantity());
                    isOptionExist = true;
                }
            }
            // else 새로 추가
            if (!isOptionExist) {
                Cart cart = Cart.builder()
                        .cartId(null)
                        .productId(productId)
                        .productItemId(option.getProductItemId())
                        .quantity(option.getQuantity())
                        .member(member)
                        .build();
                cartRepository.save(cart);
            }
        }
    }

    // 수량 수정
    public void changeCartQuantity(ChangeCartQuantityReqDto cartItem) {
        Long memberId = cartItem.getMemberId();
        Long productId = cartItem.getProductId();
        Long productItemId = cartItem.getProductItemId();
        Integer quantity = cartItem.getQuantity();

        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Cart> carts = member.getCarts();
        for (Cart cart : carts) {
            if (Objects.equals(cart.getProductId(), productId) && Objects.equals(cart.getProductItemId(), productItemId)) {
                cart.setQuantity(quantity);
                break;
            }
        }
    }

    // productItem 삭제
    public void deleteCartProductItem(@RequestBody DeleteCartProductItemReqDto cartItem) {
        Long memberId = cartItem.getMemberId();
        Long productId = cartItem.getProductId();
        Long productItemId = cartItem.getProductItemId();

        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Cart> carts = member.getCarts();
        for (Cart cart : carts) {
            if (Objects.equals(cart.getProductId(), productId) && Objects.equals(cart.getProductItemId(), productItemId)) {
                cartRepository.deleteById(cart.getCartId());
                break;
            }
        }
    }

    // product 삭제
    public void deleteCartProduct(@RequestBody DeleteCartProductReqDto cartItem) {
        Long memberId = cartItem.getMemberId();
        Long productId = cartItem.getProductId();

        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Cart> carts = member.getCarts();
        for (Cart cart : carts) {
            if (Objects.equals(cart.getProductId(), productId)) {
                cartRepository.deleteById(cart.getCartId());
            }
        }
    }
}
