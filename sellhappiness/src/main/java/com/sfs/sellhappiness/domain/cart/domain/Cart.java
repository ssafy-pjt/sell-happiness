package com.sfs.sellhappiness.domain.cart.domain;

import com.sfs.sellhappiness.domain.member.domain.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Member member;

    @OneToMany
    @JoinColumn(name = "cart_id")
    List<CartItem> cartItems = new ArrayList<>();
}
