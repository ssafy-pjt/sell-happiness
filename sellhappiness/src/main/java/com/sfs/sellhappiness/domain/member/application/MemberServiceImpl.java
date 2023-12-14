package com.sfs.sellhappiness.domain.member.application;

import com.sfs.sellhappiness.global.auth.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final JwtUtil jwtUtil;

    @Override
    public String login() {
        return jwtUtil.createJWT();
    }
}
