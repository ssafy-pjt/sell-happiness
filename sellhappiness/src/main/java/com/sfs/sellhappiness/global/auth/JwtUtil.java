package com.sfs.sellhappiness.global.auth;

import com.sfs.sellhappiness.global.error.ExceptionEnum;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;

import static com.sfs.sellhappiness.global.error.ExceptionEnum.*;

@Log4j2
@RequiredArgsConstructor
@Component
public class JwtUtil {

//    @Value("${spring.jwt.secret}")
//    private static String secretKey;
//
//    @Value("${spring.jwt.token.access-expiration-time}")
//    private static long accessExpirationTime;
//
//    @Value("${spring.jwt.token.refresh-expiration-time}")
//    private static long refreshExpirationTime;

    private final JwtProperties properties;

    /**
     * access 토큰 생성
     */
    public String createJWT() {
//        Long accessExpirationTime = properties.getAccessExpirationTime();
//        Long refreshExpirationTime = properties.getRefreshExpirationTime();
//        String secret = properties.getSecret();

        log.info("jwtproperties", properties);

//        Long accessExpirationTime = properties.getTokenAccessExpirationTime();
//        Long refreshExpirationTime = properties.getTokenRefreshExpirationTime();
        Long accessExpirationTime = 1L;
        Long refreshExpirationTime =1L;
        String secret = properties.getSecret();
        String url = properties.getUrl();

        // TODO: yml 키 설정한것들 가져오는지 확인
        log.info("시크릿키 : ", secret);
        log.info("url", url);
        log.info("액세스만료 : ", accessExpirationTime);
        log.info("리프레시만료 : ", refreshExpirationTime);

        Date now = new Date();
        Date expireDate = new Date(now.getTime() + accessExpirationTime);

        // TODO: jwt 회원정보 auth 처리해서 setsubject에 넣기
        String memberName = "test이름";

        Claims claims = Jwts.claims()
//                .setSubject(memberName)
                .setSubject("access_token")
                .setIssuedAt(now)
                .setExpiration(expireDate);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(expireDate)
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
    }

    public boolean validateJWT(String jwt) {
        try {

            return true;
        } catch (ExpiredJwtException e) {
            log.error(EXPIRED_JWT.getMessage());

            throw new RuntimeException(e);
        }
    }


}
