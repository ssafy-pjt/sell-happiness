package com.sfs.sellhappiness.domain.coupon.exception;

import lombok.Getter;

@Getter
public class alreadyUsedCouponException extends RuntimeException {
    private String message;
    private String errorCode;
}
