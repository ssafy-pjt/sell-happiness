package com.sfs.sellhappiness.global.common.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
public class Address {

    @Id
    @GeneratedValue
    @Column(name =  "address_id")
    private Long id;

    @Column(name = "member_type")
    MemberType memberType;
    private String sido;
    private String gugun;


}
