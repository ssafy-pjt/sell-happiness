package com.sfs.sellhappiness.global.auth;

import com.sfs.sellhappiness.global.config.YamlLoadFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//@Configuration
//@ConfigurationProperties(prefix = "spring.jwt")
//@PropertySource(value = {"application.yml"}, factory = YamlLoadFactory.class)
@Component
@Getter
@Setter
@ToString
public class JwtProperties {

    @Value("${spring.jwt.secret}")
    private String secret;

    @Value("${spring.datasource.h2.url}")
    private String url;
//    @Value(("${jwt.token.access-expiration-time}"))
//    private Long accessExpirationTime;
//    @Value(("${jwt.token.refresh-expiration-time}"))
//    private Long refreshExpirationTime;

//    private String secret;
//    private Long tokenAccessExpirationTime;
//    private Long tokenRefreshExpirationTime;


//    jwt:
    //    secret: cmj1014csy1201kdh0321ssy0309
//        token:
        //    access-expiration-time: 43200000 # 12시간
        //    refresh-expiration-time: 604800000 # 7일

}
