package com.sfs.sellhappiness.domain.member.exception;

import com.sfs.sellhappiness.global.error.ApiException;
import com.sfs.sellhappiness.global.error.ExceptionEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/member")
public class MemberErrorController {

    @RequestMapping("/error")
    public void error(HttpServletRequest request) throws AuthenticationException {
        String exception = (String) request.getAttribute("exception");

        if ("AuthenticationException".equals(exception)){
            throw new ApiException(ExceptionEnum.SECURITY);
        }
    }

}
