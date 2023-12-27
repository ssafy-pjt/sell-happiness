package com.sfs.sellhappiness.domain.member.dto;

import lombok.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReqMemberLogin {

    private String email;
    private String password;
}
