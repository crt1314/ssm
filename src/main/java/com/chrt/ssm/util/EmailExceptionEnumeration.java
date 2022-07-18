package com.chrt.ssm.util;

/**
 * 封装邮箱可能抛出的异常信息类
 */
public enum EmailExceptionEnumeration {
    /**
     * 邮箱异常信息实例
     */
    EMAIL_FAILED_TO_SEND("Failed to send email."),
    EMAIL_FAILED_TO_SET_MESSAGE("Failed to set email message."),
    EMAIL_FAILED_TO_INSERT("Failed to insert email."),
    EMAIL_FAILED_TO_MEET_REQUIREMENTS("Failed to meet requirements."),
    WRONG_CHOICE("The choice is wrong.");

    /**
     * 异常信息
     */
    private final String message;

    /**
     * 异常信息构造方法
     * @param message 异常信息
     */
    EmailExceptionEnumeration(String message) {
        this.message = message;
    }

    /**
     * 获取异常信息
     * @return 异常信息
     */
    public String getMessage() {
        return this.message;
    }
}
