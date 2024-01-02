package com.sfs.sellhappiness.global.auth.dto;

import com.sfs.sellhappiness.global.auth.domain.Token;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
public class ResToken {
    private String accessToken;
    private String refreshToken;

    public ResToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public ResToken toDto(Token token) {
        accessToken = token.getRefreshToken();
        refreshToken = token.getRefreshToken();
        return this;
    }
}
