package com.sfs.sellhappiness.domain.member.domain;

import com.sfs.sellhappiness.global.common.domain.Address;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50)
    private String email;
//    @Column(length = 10)
//    private String emailDomain;
    @Column(length = 20)
    private String password;
    @Column(length = 100)
    private String name;

//    @OneToOne
//    @JoinColumn(name = "address_id")
//    Address address;
//
//    private LocalDateTime registDate;
//    @Column(length = 20)
//    private String nickName;

    // 토큰


}
