package com.sfs.sellhappiness.payment.exception;

import lombok.Getter;

@Getter
public class verifyIamportException extends RuntimeException {
    private String message;
    private String errorCode;

}
