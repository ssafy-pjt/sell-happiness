package com.sfs.sellhappiness.domain.coupon.exception;

import lombok.Getter;

@Getter
public class notExistCouponException extends RuntimeException {
    private String message;
    private String errorCode;
}
