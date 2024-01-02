package com.sfs.sellhappiness.domain.member.domain;

import com.sfs.sellhappiness.domain.cart.domain.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_email")
    private String memberEmail;

    @OneToMany(mappedBy = "member")
    List<Cart> carts = new ArrayList<>(); // TODO: List vs ArrayList // Could not set value of type [org.hibernate.collection.spi.PersistentBag]:
}
