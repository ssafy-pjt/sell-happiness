package com.sfs.sellhappiness.domain.coupon.exception;

import lombok.Getter;

@Getter
public class expiredCouponException extends RuntimeException {
    private String message;
    private String errorCode;
}
