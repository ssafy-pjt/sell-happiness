package com.sfs.sellhappiness.global.auth.domain;

import com.sfs.sellhappiness.global.common.BaseTimeEntity;
import com.sfs.sellhappiness.global.common.domain.MemberType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.domain.Persistable;

import java.util.Date;


@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token extends BaseTimeEntity implements Persistable<Long> {
//public class Token extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

//    private Long memberId;
    private String email;
    private String refreshToken;
    private Date expireDate;
//    private MemberType memberType;

    @Builder
//    private Token(Long memberId, String refreshToken, Date expireDate) {
    public Token(String email, String refreshToken, Date expireDate) {
        this.email = email;
        this.refreshToken = refreshToken;
        this.expireDate = expireDate;
//        this.memberType = memberType;
    }


    @Override
    public boolean isNew() {
        return id == null;
    }
}
