package com.chrt.ssm.util;

/**
 * 实现Email格式验证
 */
public class EmailHelper {

    /**
     * 私有化构造器
     */
    private EmailHelper() {}

    /**
     * 判断邮箱格式是否正确
     * @param message 邮箱信息
     * @param choice 邮箱格式
     * @return 正确与否标志
     */
    public static Boolean isEmailMeetsRequirements(String message, String choice) {
        return EmailRegexEnumeration.matches(message, choice);
    }
}
