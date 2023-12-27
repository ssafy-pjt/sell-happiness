package com.sfs.sellhappiness.domain.member.api;

import com.sfs.sellhappiness.domain.member.application.MemberService;
import com.sfs.sellhappiness.domain.member.dto.ReqMemberLogin;
import com.sfs.sellhappiness.global.auth.JwtProperties;
import com.sfs.sellhappiness.global.auth.dto.ResToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // jwt 테스트
    // TODO: 회원 DTO 만들어서 JWT 테스트
    @PostMapping("/login")
    public ResponseEntity<ResToken> login(@RequestBody ReqMemberLogin reqMemberLogin) {
        log.info("login() =====");

        return ResponseEntity.ok()
                .body(memberService.login(reqMemberLogin));
    }


}
