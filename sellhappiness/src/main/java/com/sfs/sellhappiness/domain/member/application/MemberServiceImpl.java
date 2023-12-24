package com.sfs.sellhappiness.domain.member.application;

import com.sfs.sellhappiness.domain.member.dao.MemberJpaRepository;
import com.sfs.sellhappiness.domain.member.dto.ReqMemberLogin;
import com.sfs.sellhappiness.global.auth.JwtProvider;
import com.sfs.sellhappiness.global.auth.dto.ResToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Log4j2
public class MemberServiceImpl implements MemberService{

    private final JwtProvider jwtProvider;
    private final MemberJpaRepository memberJpaRepository;
    private final AuthenticationManager authenticationManager;


    @Override
    public ResToken login(ReqMemberLogin reqMemberLogin) {
        /**
         * TODO: authentication 인증 후 토큰 만들기
         * 1. authentication 인증
         * 2. 액세스, 리프레시 토큰 생성
         * 3. 토큰 반환
         */
//        memberJpaRepository.findByLoginInfo()

//        UsernamePasswordAuthenticationToken
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        reqMemberLogin.getEmail(),
                        reqMemberLogin.getPassword()
                )
        );

//        authenticationManager.au
//        return jwtUtil.createAccessJWT();

        return null;
    }

    // 참고
//    @Transactional
//    public TokenDto login(UserLoginReqDto userLoginReqDto) throws BaseException {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            userLoginReqDto.getNum(),
//                            userLoginReqDto.getPassword()
//                    )
//            );
//
//            TokenDto tokenDto = new TokenDto(
//                    jwtTokenProvider.createAccessToken(authentication),
//                    jwtTokenProvider.createRefreshToken(authentication)
//            );
//
//            return tokenDto;
//
//        }catch(BadCredentialsException e){
//            log.error(INVALID_USER_PW.getMessage());
//            throw new BaseException(INVALID_USER_PW);
//        }
//    }
}
