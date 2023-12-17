package com.sfs.sellhappiness.domain.cart.domain;

import com.sfs.sellhappiness.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
