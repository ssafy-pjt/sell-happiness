package com.sfs.sellhappiness.global.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/jwt")
public class JWTErrorController {

    // TODO: JWT 에러 처리하기
    @RequestMapping("/error")
    public void error(HttpServletRequest request) throws AuthenticationException {
        String exception = (String) request.getAttribute("exception");

        if ("JWTExpiredException".equals(exception)) {
            throw new ApiException(ExceptionEnum.EXPIRED_JWT);
        } else if ("JWTInvalidException".equals(exception)) {
            throw new ApiException(ExceptionEnum.INVALID_JWT);
        }
    }
}
