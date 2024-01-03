package com.sfs.sellhappiness.global.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Configuration
//@ConfigurationProperties(prefix = "spring.jwt")
//@PropertySource(value = {"application.yml"}, factory = YamlLoadFactory.class)
@Component
@Getter
@Setter
@ToString
public class JwtProperties {

    @Value("${jwt.secret}")
    private String secret;

    @Value(("${jwt.token.access-expiration-time}"))
    private Long accessExpirationTime;
    @Value(("${jwt.token.refresh-expiration-time}"))
    private Long refreshExpirationTime;

}
