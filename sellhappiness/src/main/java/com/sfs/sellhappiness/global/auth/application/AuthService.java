package com.sfs.sellhappiness.global.auth.application;

import com.sfs.sellhappiness.global.auth.JwtProvider;
import com.sfs.sellhappiness.global.auth.dao.TokenJpaRepository;
import com.sfs.sellhappiness.global.auth.domain.Token;
import com.sfs.sellhappiness.global.auth.dto.ResToken;
import com.sfs.sellhappiness.global.error.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static com.sfs.sellhappiness.global.error.ExceptionEnum.NOT_EXIST_REFRESH_JWT;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final TokenJpaRepository tokenJpaRepository;

    /**
     * 리프레시 토큰 검증 후 결과에 따라 리프레시 토큰을 재발행한다.
     */
    public ResToken reissueToken(String refreshToken) {
        jwtProvider.validateJWT(refreshToken);

        // 유저 정보 가져오기
        Authentication authentication = jwtProvider.getAuthentication(refreshToken);

        String storedRefresh = tokenJpaRepository.findByEmail(authentication.getName())
                .getRefreshToken();

        if (!storedRefresh.equals(refreshToken)) {
            throw new ApiException(NOT_EXIST_REFRESH_JWT);
        }

        return new ResToken(
                jwtProvider.createAccessJWT(authentication),
                jwtProvider.createRefreshJWT(authentication)
        );
    }

    public ResToken getToken(String email) {
        Token token = tokenJpaRepository.findByEmail(email);
        log.info("받은 토큰 {}", token);
        return new ResToken().toDto(token);

    }
}
