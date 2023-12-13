package com.sfs.sellhappiness.domain.member.application;

import com.sfs.sellhappiness.global.auth.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Override
    public String login() {
        return JwtUtil.createJWT();
    }
}
