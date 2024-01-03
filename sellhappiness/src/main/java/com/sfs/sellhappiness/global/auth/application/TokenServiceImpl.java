package com.sfs.sellhappiness.global.auth.application;

import com.sfs.sellhappiness.global.auth.dao.TokenJpaRepository;
import com.sfs.sellhappiness.global.auth.domain.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class TokenServiceImpl implements TokenService{

    private final TokenJpaRepository tokenJpaRepository;

    @Override
    public void saveToken(Token token) {

        // 리프레시 토큰 저장
        // 회원
        log.info("받은 토큰 정보 : {}", token);
        // TODO: 토큰 저장이 안되는이유?
        Token save = tokenJpaRepository.save(token);
        log.info("저장 후 토큰 정보 : {}", save);


    }
}
