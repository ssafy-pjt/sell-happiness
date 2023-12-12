package com.sfs.sellhappiness.global.common;

import com.sfs.sellhappiness.global.error.ApiExceptionEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ApiResult {
    private String status;
    private String message;
    private ApiExceptionEntity exception;

    @Builder
    public ApiResult(String status, String message, ApiExceptionEntity exception) {
        this.status = status;
        this.message = message;
        this.exception = exception;
    }
}
