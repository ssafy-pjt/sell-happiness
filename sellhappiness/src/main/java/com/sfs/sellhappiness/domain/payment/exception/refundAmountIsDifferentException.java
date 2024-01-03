package com.sfs.sellhappiness.domain.payment.exception;

import lombok.Getter;

@Getter
public class refundAmountIsDifferentException extends RuntimeException {
    private String message;
    private String errorCode;
}
