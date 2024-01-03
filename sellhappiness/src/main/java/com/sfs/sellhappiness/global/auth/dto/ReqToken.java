package com.sfs.sellhappiness.global.auth.dto;

import com.sfs.sellhappiness.global.auth.domain.Token;
import com.sfs.sellhappiness.global.common.domain.MemberType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReqToken {

//    private Long memberId;
    private String email;
    private String refreshToken;
    private Date expireDate;
//    private MemberType memberType;

    public Token toEntity(ReqToken reqToken) {
        return Token.builder()
//                .memberId(reqToken.getMemberId())
                .email(reqToken.getEmail())
                .refreshToken(reqToken.getRefreshToken())
                .expireDate(reqToken.getExpireDate())
//                .memberType(reqToken.getMemberType())
                .build();
    }
}
