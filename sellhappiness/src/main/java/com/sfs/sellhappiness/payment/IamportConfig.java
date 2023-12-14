package com.sfs.sellhappiness.payment;

import com.sfs.sellhappiness.global.config.YamlLoadFactory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ConfigurationProperties(prefix = "iamport")
@PropertySource(value = {"application-iamport.yml"}, factory = YamlLoadFactory.class)
@Getter
public class IamportConfig {

    @Value("${iamport.api.key}")
    private String key;

    @Value("${iamport.api.secret}")
    private String secret;
}