package com.sfs.sellhappiness.domain.cart.domain;

import com.sfs.sellhappiness.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cart")
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_item_id")
    private Long productItemId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
