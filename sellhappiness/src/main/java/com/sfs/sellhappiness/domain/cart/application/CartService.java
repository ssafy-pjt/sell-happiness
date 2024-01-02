package com.sfs.sellhappiness.domain.cart.application;

import com.sfs.sellhappiness.domain.cart.dao.CartItemRepository;
import com.sfs.sellhappiness.domain.cart.dao.CartRepository;
import com.sfs.sellhappiness.domain.cart.domain.Cart;
import com.sfs.sellhappiness.domain.cart.domain.CartItem;
import com.sfs.sellhappiness.domain.cart.dto.req.AddCartItemReqDto;
import com.sfs.sellhappiness.domain.cart.dto.res.CartItemsResDto;
import com.sfs.sellhappiness.domain.cart.dto.res.CartItemsResInterface;
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

    // 장바구니에 상품 추가
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
            for (int i = 0; i < cartItemReqDtos.size(); i++) {
                AddCartItemReqDto reqCartItem = cartItemReqDtos.get(i);
                boolean isProductExist = false;
                boolean isOptionExist = false;
                for (CartItem item : cart.getCartItems()) {
                    // 이미 존재하는 상품 + 이미 존재하는 옵션 : 수량만 증가
                    if (item.getProductId() == productId && item.getProductItemId() == reqCartItem.getProductOptionId()) {
                        CartItem cartItem = cartItemRepository.findById(item.getCartItemId()).orElseThrow();
                        Integer updatedQuantity = cartItem.getQuantity() + reqCartItem.getQuantity();
                        cartItem.setQuantity(updatedQuantity);
                        isProductExist = true;
                        isOptionExist = true;
                    }
                }
                // 이미 존재하는 상품 + 새로운 옵션 : 새로 추가
                // 새 상품 : 새로 추가
                if (!isOptionExist) {
                    CartItem cartItem = CartItem.builder()
                            .productId(productId)
                            .productItemId(reqCartItem.getProductOptionId())
                            .quantity(reqCartItem.getQuantity())
                            .cart(cart)
                            .build();
                    cartItemRepository.save(cartItem);
                }
            }
            System.out.println("exist cart");
        }
    }

    // 장바구니 목록 가져오기
    public void getCartItems() {
        List<CartItemsResInterface> cartItems = cartRepository.findCartItems();
        System.out.println("get cart items");
    }
}
