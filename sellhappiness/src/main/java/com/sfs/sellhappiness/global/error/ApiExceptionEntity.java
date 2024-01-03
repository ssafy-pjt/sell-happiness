package com.sfs.sellhappiness.global.error;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ApiExceptionEntity {
    private final String errorCode;
    private final String errorMessage;

    @Builder
    public ApiExceptionEntity(HttpStatus status, String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
