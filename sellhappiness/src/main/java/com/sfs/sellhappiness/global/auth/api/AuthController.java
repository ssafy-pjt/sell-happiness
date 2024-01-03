package com.sfs.sellhappiness.global.auth.api;

import com.sfs.sellhappiness.global.auth.application.AuthService;
import com.sfs.sellhappiness.global.auth.dto.ResToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {

    private final AuthService authService;

    @PostMapping("/reissue")
    public ResponseEntity<ResToken> reissue(String refreshToken) {
        return ResponseEntity.ok()
                .body(authService.reissueToken(refreshToken));
    }

    @GetMapping("/test")
    public ResponseEntity<ResToken> getRefresh(@RequestParam(value = "email") String email) {
        log.info("AuthController.getRefresh ===> 받은 이메일 : {}", email);
        return ResponseEntity.ok()
                .body(authService.getToken(email));
    }
}
