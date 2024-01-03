package com.sfs.sellhappiness.global.auth.application;

import com.sfs.sellhappiness.global.auth.domain.Token;

public interface TokenService {

    public void saveToken(Token token);
}
