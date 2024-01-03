package com.sfs.sellhappiness.domain.member.application;

import com.sfs.sellhappiness.domain.member.dto.ReqMemberLogin;
import com.sfs.sellhappiness.global.auth.dto.ResToken;

public interface MemberService {

    public ResToken login(ReqMemberLogin reqMemberLogin);
}
