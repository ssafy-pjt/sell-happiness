package com.sfs.sellhappiness.domain.member.api;

import com.sfs.sellhappiness.domain.member.application.MemberService;
import com.sfs.sellhappiness.global.auth.JwtProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final JwtProperties properties;

    // jwt 테스트
    // TODO: 회원 DTO 만들어서 JWT 테스트
    @PostMapping("/login")
    public ResponseEntity<String> login() {
        log.info("■■■■ 컨트롤러 ");
        log.info("시크릿키", properties.getSecret());
        log.info("url", properties.getUrl());
        log.info("■■■■ 컨트롤러 종료");

        return ResponseEntity.ok()
                .body(memberService.login());
    }


}
