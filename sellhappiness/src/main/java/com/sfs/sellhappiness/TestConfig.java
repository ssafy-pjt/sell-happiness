package com.sfs.sellhappiness;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TestConfig {
    @Value("${spring.datasource.h2.url}")
    private String url;

}
