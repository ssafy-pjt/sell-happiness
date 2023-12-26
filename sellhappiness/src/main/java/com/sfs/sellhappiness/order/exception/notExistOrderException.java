package com.sfs.sellhappiness.order.exception;

import lombok.Getter;

@Getter
public class notExistOrderException extends RuntimeException{
    private String message;
    private String errorCode;
}
