package com.sfs.sellhappiness.global.auth.dao;

import com.sfs.sellhappiness.global.auth.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<Token, Long> {

    public Token findByEmail(String email);

}
