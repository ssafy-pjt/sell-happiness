package com.sfs.sellhappiness.domain.member.domain;

import com.sfs.sellhappiness.domain.cart.domain.Cart;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_email")
    private String memberEmail;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
