package com.sfs.sellhappiness.global.auth.domain;

import com.sfs.sellhappiness.global.common.BaseTimeEntity;
import com.sfs.sellhappiness.global.common.domain.MemberType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long memberId;
    private String refreshToken;
    private LocalDateTime expireDate;
    private MemberType memberType;

    @Builder
    private Token(Long memberId, String refreshToken, LocalDateTime expireDate, MemberType memberType) {
        this.memberId = memberId;
        this.refreshToken = refreshToken;
        this.expireDate = expireDate;
        this.memberType = memberType;
    }
}
