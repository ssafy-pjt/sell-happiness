package com.sfs.sellhappiness.domain.member.domain;

import com.sfs.sellhappiness.global.common.BaseTimeEntity;
import com.sfs.sellhappiness.global.common.domain.Address;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50)
    private String email;
    @Column(length = 128)
    private String password;
    @Column(length = 100)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;

    @Column(length = 20)
    private String nickName;
  
    @OneToMany(mappedBy = "member")
    List<Cart> carts = new ArrayList<>(); 

    @Builder
    private Member(String email, String password, String name, Address address, String nickName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.nickName = nickName;
    }
}
