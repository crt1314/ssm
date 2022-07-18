package com.chrt.ssm.util;

import com.chrt.ssm.exception.EmailException;

/**
 * 邮箱异常枚举类包装类
 */
public class EmailExceptionEnumerationWrapper {

    /**
     * 私有化构造器
     */
    private EmailExceptionEnumerationWrapper() {}

    /**
     * 抛出EmailException异常
     * @param enumeration 异常枚举类
     * @param e 来源异常
     * @throws EmailException 邮箱异常
     */
    public static void wee(EmailExceptionEnumeration enumeration, Exception e) throws EmailException {
        throw new EmailException(enumeration.getMessage(), e);
    }

    /**
     * 抛出EmailException异常
     * @param enumeration 异常枚举类
     * @throws EmailException 邮箱异常
     */
    public static void wee(EmailExceptionEnumeration enumeration) throws EmailException {
        throw new EmailException(enumeration.getMessage());
    }
}
