package com.sfs.sellhappiness.domain.member.api;

import com.sfs.sellhappiness.domain.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // jwt 테스트
    // TODO: 회원 DTO 만들어서 JWT 테스트
    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok()
                .body(memberService.login());
    }
}
