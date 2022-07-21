package com.chrt.ssm.util;

import com.chrt.ssm.exception.UserException;
import com.chrt.ssm.exception.enumeration.UserExceptionWrapperEnumeration;
import com.chrt.ssm.mapper.UserMapper;
import com.chrt.ssm.pojo.User;

/**
 * 用户相关操作帮助类
 */
public class UserHelper {
    /**
     * 私有化构造器
     */
    private UserHelper() {}

    /**
     * 抛出UserException异常
     * @param ordinal 异常索引
     * @throws UserException 用户异常
     */
    public static void throwUserException(int ordinal) throws UserException {
        UserExceptionWrapperEnumeration.values()[ordinal].throwUserException();
    }

    /**
     * 抛出UserException异常
     * @param ordinal 异常索引
     * @param e 来源异常
     * @throws UserException 用户异常
     */
    public static void throwUserException(int ordinal, Exception e) throws UserException {
        UserExceptionWrapperEnumeration.values()[ordinal].throwUserException(e);
    }

    /**
     * 添加用户信息
     * @param user 用户信息
     * @param userMapper 用户持久层
     * @throws UserException 用户添加失败异常
     */
    public static void addUser(User user, UserMapper userMapper) throws UserException {
        Integer integer = userMapper.addUser(user);
        if (integer == null || integer == 0) {
            UserHelper.throwUserException(2);
        }
    }

    /**
     * 检查用户名是否存在
     * @param user 用户信息
     * @param userMapper 用户持久层
     * @throws UserException 用户已存在、查询失败异常
     */
    public static void checkUser(User user, UserMapper userMapper) throws UserException {
        Integer count = userMapper.getUserByUsername(user);
        if (count != null && count > 0) {
            throwUserException(0);
        } else if (count == null) {
            throwUserException(3);
        }
    }
}
