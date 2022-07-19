package com.chrt.ssm.util;

import com.chrt.ssm.exception.EmailException;

/**
 * 封装邮箱可能抛出的异常信息类
 */
public enum EmailExceptionEnumeration {
    /**
     * 发送邮箱异常
     */
    EMAIL_FAILED_TO_SEND("Failed to send email.", 0),

    /**
     * 邮箱设置信息异常
     */
    EMAIL_FAILED_TO_SET_MESSAGE("Failed to set email message.", 1),

    /**
     * 添加邮箱异常
     */
    EMAIL_FAILED_TO_INSERT("Failed to insert email.", 2),

    /**
     * 邮箱格式错误
     */
    EMAIL_FAILED_TO_MEET_REQUIREMENTS("Failed to meet requirements.", 3),

    /**
     * 邮箱选择错误
     */
    EMAIL_WRONG_CHOICE("The choice is wrong.", 4),

    /**
     * 邮箱更新失败
     */
    EMAIL_FAILED_TO_UPDATE("Failed to update email.", 5),

    /**
     * 邮箱删除失败
     */
    EMAIL_FAILED_TO_DELETE("Failed to delete email.", 6),

    /**
     * 邮箱操作模式错误
     */
    EMAIL_WRONG_MODE("The mode is wrong", 7);

    /**
     * 异常信息
     */
    private final String message;

    /**
     * 异常信息构造方法
     * @param message 异常信息
     * @param id 异常索引
     */
    EmailExceptionEnumeration(String message, Integer id) {
        this.message = message;
    }

    /**
     * 抛出邮箱异常
     * @param e 来源异常类
     * @throws EmailException 邮箱异常
     */
    public void throwEmailException(Exception e) throws EmailException {
        throw new EmailException(this.message, e);
    }

    /**
     * 抛出邮箱异常
     * @throws EmailException 邮箱异常
     */
    public void throwEmailException() throws EmailException {
        throw new EmailException(this.message);
    }
}
