package com.chrt.ssm.util;

import com.chrt.ssm.exception.EmailException;
import com.chrt.ssm.mapper.EmailMapper;

/**
 * 实现Email相关方法
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

    /**
     * 抛出邮箱异常
     * @param ordinal 邮箱异常信息类实例的ordinal
     * @param e 来源异常
     * @throws EmailException 邮箱异常
     */
    public static void throwEmailException(int ordinal, Exception e) throws EmailException {
        EmailExceptionEnumeration.values()[ordinal].throwEmailException(e);
    }

    /**
     * 抛出邮箱异常
     * @param ordinal 邮箱异常信息类实例的ordinal
     * @throws EmailException 邮箱异常
     */
    public static void throwEmailException(int ordinal) throws EmailException {
        EmailExceptionEnumeration.values()[ordinal].throwEmailException();
    }

    /**
     * 获取枚举类的ordinal
     * @param name 枚举类名称
     * @return 枚举类的ordinal或null
     */
    public static Integer getOrdinal(String name) {
        try {
            return EmailRegexEnumeration.valueOf(name).ordinal();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * 邮箱增删改操作帮助类
     * @param email 邮箱信息
     * @param choice 邮箱格式
     * @param user_id 用户唯一标识
     * @param username 用户名称
     * @param mode 增删改模式
     * @param mapper 持久层操作类
     * @throws EmailException 邮箱异常
     */
    public static void UpdateHelper(
            String email, String choice, Integer user_id, String username, UpdateMode mode, EmailMapper mapper
    ) throws EmailException {
        Boolean flag = isEmailMeetsRequirements(email, choice);
        Integer ordinal = getOrdinal(choice);
        if (flag != null && flag && ordinal != null && mode != null) {
            mapperHelper(mode, mapper, email, ordinal, username, user_id);
        } else if (flag != null && ordinal != null && mode != null){
            throwEmailException(3);
        } else if (mode == null && flag != null && ordinal != null) {
            throwEmailException(7);
        } else {
            throwEmailException(4);
        }
    }

    /**
     * 增删改模式类
     */
    private enum UpdateMode {
        /**
         * 添加
         */
        INSERT,
        /**
         * 修改
         */
        UPDATE,
        /**
         * 删除
         */
        DELETE
    }

    /**
     * 外界获取增删改模式类
     * @param mode 模式选择
     * @return 模式类
     */
    public static UpdateMode getUpdateMode(String mode) {
        try {
            return UpdateMode.valueOf(mode);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * 持久层帮助方法
     * @param mode 模式
     * @param mapper 持久层类
     * @param email 邮箱信息
     * @param ordinal 邮箱格式
     * @param username 用户名称
     * @param user_id 用户唯一标识
     * @throws EmailException 邮箱异常
     */
    private static void mapperHelper(
            UpdateMode mode, EmailMapper mapper, String email, Integer ordinal, String username, Integer user_id
    ) throws EmailException {
        Integer count;
        switch (mode) {
            case DELETE:
                count = mapper.deleteEmail(email, username, user_id, ordinal + 1);
                if (count == null || count == 0) {
                    throwEmailException(6);
                }
                break;
            case UPDATE:
                count = mapper.updateEmail(email, username, user_id, ordinal + 1);
                if (count == null || count == 0) {
                    throwEmailException(5);
                }
                break;
            case INSERT:
                count = mapper.insertEmail(email, username, user_id, ordinal + 1);
                if (count == null || count == 0) {
                    throwEmailException(2);
                }
                break;
        }
    }
}
