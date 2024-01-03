package com.sfs.sellhappiness.domain.oauth.application;


public interface OAuthService {
    public void socialLogin(String code, String registrationId);
}
