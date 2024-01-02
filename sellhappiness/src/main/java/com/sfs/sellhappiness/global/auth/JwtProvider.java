package com.sfs.sellhappiness.global.auth;

import com.sfs.sellhappiness.domain.member.application.MemberDetailsServiceImpl;
import com.sfs.sellhappiness.global.auth.application.TokenService;
import com.sfs.sellhappiness.global.auth.domain.Token;
import com.sfs.sellhappiness.global.auth.dto.ReqToken;
import com.sfs.sellhappiness.global.common.domain.MemberType;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static com.sfs.sellhappiness.global.error.ExceptionEnum.*;

@Log4j2
//@RequiredArgsConstructor
@Component
public final class JwtProvider {

    // 추가
    private final Key secretKey;
    private final Long accessExpirationTime;
    private final Long refreshExpirationTime;

    @Autowired
    private MemberDetailsServiceImpl memberDetailsService;
    @Autowired
    private TokenService tokenService;

    public JwtProvider(JwtProperties properties) {
        byte[] keyBytes = Decoders.BASE64.decode(properties.getSecret());
        secretKey = Keys.hmacShaKeyFor(keyBytes);
        accessExpirationTime = properties.getAccessExpirationTime();
        refreshExpirationTime = properties.getRefreshExpirationTime();
        log.info("decode 값 : {} ", keyBytes);
        log.info("시크릿키 : {}", secretKey);
        log.info("액세스만료 {} ", accessExpirationTime);
        log.info("리프레시만료 {} ", refreshExpirationTime);
//        this.properties = properties;
    }

    /**
     * access 토큰 생성
     */
//        public String createAccessToken(Authentication authentication){
    public String createAccessJWT(Authentication authentication) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + accessExpirationTime);

        Claims claims = Jwts.claims()
//                .setSubject(memberName)
//                .setSubject("access_token")
                .setSubject(authentication.getName()) //
                .setIssuedAt(now)
                .setExpiration(expireDate);

        // TODO: jwt 회원정보 auth 처리해서 claims에 넣기
        // role, 사용자명 정도만 넣기
        String memberName = "test이름";
        claims.put("memberName", memberName);
        claims.put("roles", "권한정보넣기");

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String createRefreshJWT(Authentication authentication) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + refreshExpirationTime);
        String emailId = authentication.getName();

        Claims claims = Jwts.claims()
                .setSubject(emailId) // 회원정보넣기
                .setIssuedAt(now)
                .setExpiration(expireDate);

        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        // TODO: DB에 JWT 저장하기
        // 회원 ID, 토큰, 만료일, 멤버타입
        ReqToken reqToken = new ReqToken(emailId, jwt, expireDate);
        Token tokenEntity = reqToken.toEntity(reqToken);
        // 저장
        tokenService.saveToken(tokenEntity);

        return jwt;
    }

    /**
     * 토큰 검증
     */
    public boolean validateJWT(String jwt) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(jwt);
            return true;

        } catch (ExpiredJwtException e) {
            log.error(EXPIRED_JWT.getMessage());
            throw new RuntimeException(e);

        } catch (JwtException e) {
            log.error(INVALID_JWT.getMessage());
            // TODO: 임시 에러 처리
            throw new RuntimeException(e);
        }
    }

    /**
     * 토큰으로부터 클레임을 만들고, 이를 통해 User 객체 생성해 Authentication 객체 반환
     */
    public Authentication getAuthentication(String token){
        String userPrincipal = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        UserDetails userDetails = memberDetailsService.loadUserByUsername(userPrincipal);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


}
