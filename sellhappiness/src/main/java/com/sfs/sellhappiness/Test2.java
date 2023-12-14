package com.sfs.sellhappiness;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Test2 {
    private final TestConfig testConfig;

    @PostConstruct
    void init() {
        System.out.println("testConfig = " + testConfig.getUrl());
    }
}
