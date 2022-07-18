package com.chrt.ssm.exception;

/**
 * 邮箱异常
 */
public class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }
    public EmailException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
