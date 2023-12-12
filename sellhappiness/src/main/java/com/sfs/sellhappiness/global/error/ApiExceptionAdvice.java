package com.sfs.sellhappiness.global.error;

import com.sfs.sellhappiness.global.common.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.Retention;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request, final ApiException e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorCode(e.getError().getCode())
                .errorMessage(e.getError().getMessage())
                .build();

//        e.printStackTrace();

        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiResult.builder()
                        .status("error")
                        .message("")
                        .exception(apiExceptionEntity)
                        .build());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorCode(ExceptionEnum.RUNTIME_EXCEPTION.getCode())
                .errorMessage(e.getMessage())
                .build();

        e.printStackTrace();

        return ResponseEntity
                .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
                .body(ApiResult.builder()
                        .status("error")
                        .message("")
                        .exception(apiExceptionEntity)
                        .build()
                );
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request, final AccessDeniedException e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorMessage(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getCode())
                .errorMessage(e.getMessage())
                .build();

        e.printStackTrace();

        return ResponseEntity
                .status(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
                .body(ApiResult.builder()
                        .status("error")
                        .message("")
                        .exception(apiExceptionEntity)
                        .build()
                );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request, final Exception e){
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                .errorMessage(e.getMessage())
                .build();

        e.printStackTrace();

        return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiResult.builder()
                        .status("error")
                        .message("")
                        .exception(apiExceptionEntity)
                        .build()
                );
    }
}