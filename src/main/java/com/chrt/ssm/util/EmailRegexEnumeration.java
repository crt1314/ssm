package com.chrt.ssm.util;

/**
 * 罗列可能的邮箱格式
 */
public enum EmailRegexEnumeration {

    /**
     * qq
     */
    QQ("^[1-9][0-9]{4,}@qq\\.com$"),

    /**
     * 163
     */
    E163("^((1[0-9]{10})|([a-zA-Z][a-zA-Z0-9_]{5,17}))@163\\.com$"),

    /**
     * 163VIP
     */
    E163VIP("^[a-zA-Z][a-zA-Z0-9\\._]{3, 18}[a-zA-Z0-9_]@((vip\\.((163)|(126)))|(188))\\.com$");

    /**
     * 邮箱格式
     */
    private final String regex;

    /**
     * 格式构造方法
     * @param regex 格式
     */
    EmailRegexEnumeration(String regex) {
        this.regex = regex;
    }

    /**
     * 获取邮箱格式
     * @return 邮箱格式
     */
    public String getRegex() {
        return this.regex;
    }

    /**
     * 判断邮箱格式是否正确
     * 如果choice不存在则返回null
     * 如果choice存在且正确返回true
     * 如果choice存在且错误返回false
     * @param message 邮箱信息
     * @param choice 用于查找指定的格式
     * @return 邮箱格式正确与否标志
     */
    public static Boolean matches(String message, String choice) {
        try {
            return message.matches(EmailRegexEnumeration.valueOf(choice).getRegex());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
