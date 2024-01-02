package com.sfs.sellhappiness.global.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    // System Exception E 1000번대
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E1000"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E1001"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E1002"),

    // Custom Exception E 1000번대
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED,"CE1000","만료된 Access 토큰입니다. Refresh 토큰을 이용해서 새로운 Access 토큰을 발급 받으세요."),
    INVALID_JWT(HttpStatus.UNAUTHORIZED, "CE1001", "지원되지 않거나 잘못된 토큰 입니다."),
    NOT_EXIST_REFRESH_JWT(HttpStatus.UNAUTHORIZED, "CE1002", "존재하지 않거나 만료된 Refresh 토큰입니다. 다시 로그인해주세요"),

    // Member Exception E 2000번대
    SECURITY(HttpStatus.UNAUTHORIZED, "CE2000", "로그인이 필요합니다."),
    INVALID_USER_EMAIL(HttpStatus.UNAUTHORIZED, "CE2001", "존재하지 않는 이메일입니다.")
    ;


    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
