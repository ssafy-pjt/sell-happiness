package com.sfs.sellhappiness.domain.member.application;

import com.sfs.sellhappiness.domain.member.dao.MemberJpaRepository;
import com.sfs.sellhappiness.domain.member.dto.ReqMemberLogin;
import com.sfs.sellhappiness.global.auth.JwtProvider;
import com.sfs.sellhappiness.global.auth.dto.ResToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Log4j2
public class MemberServiceImpl implements MemberService {

    private final JwtProvider jwtProvider;
    private final MemberJpaRepository memberJpaRepository;
    private final AuthenticationManager authenticationManager;


    @Override
    public ResToken login(ReqMemberLogin reqMemberLogin) {
        /**
         * TODO: authentication 인증 후 토큰 만들기
         * 1. authentication 인증
         *   - DB에서 email로 refresh토큰 가져와서 만료기간이 안지났으면 access token 재발급
         * 2. 액세스, 리프레시 토큰 생성 (만료기간이 지났으면 access, refresh token 재발급)
         * 3. 토큰 반환
         */

        log.info("email = {}", reqMemberLogin.getEmail());
        log.info("password = {}", reqMemberLogin.getPassword());
//        log.info("authentication start ==========");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        reqMemberLogin.getEmail(),
                        reqMemberLogin.getPassword()
                )
        );

        String accessToken = jwtProvider.createAccessJWT(authentication);
        // refreshToken 생성
        String refreshToken = jwtProvider.createRefreshJWT(authentication);
        return new ResToken(accessToken, refreshToken);
    }

}
