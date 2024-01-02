package com.sfs.sellhappiness.domain.member.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum MemberStatus {

    Reg("regular", "정상"),
    Dor("dormant", "휴면"),
    WTD("withdrawal", "탈퇴");

    private String statusEng;
    private String statusKor;

    MemberStatus(String statusEng, String statusKor) {
        this.statusEng = statusEng;
        this.statusKor = statusKor;
    }

    public String getStatusEng() {
        return statusEng;
    }

    public String getStatusKor() {
        return statusKor;
    }
}
