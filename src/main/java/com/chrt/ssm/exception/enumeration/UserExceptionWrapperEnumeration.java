package com.chrt.ssm.exception.enumeration;

import com.chrt.ssm.exception.UserException;

/**
 * 用户异常信息包装类
 */
public enum UserExceptionWrapperEnumeration {

    /**
     * 用户名已存在
     */
    USERNAME_EXISTS("Username exists", 0),

    /**
     * 用户用户名或密码错误
     */
    WRONG_USERNAME_OR_PASSWORD("Username or Password is wrong.", 1),

    /**
     * 添加用户失败
     */
    ADD_USER_WRONG("Failed to add user.", 2),

    /**
     * 查询用户信息失败
     */
    SELECT_USER_FAILED("Failed to get user message", 3);

    /**
     * 异常信息
     */
    private final String message;

    /**
     * 构造器
     * @param message 异常信息
     * @param id 异常索引
     */
    UserExceptionWrapperEnumeration(String message, Integer id) {
        this.message = message;
    }

    /**
     * 抛出UserException异常
     * @param e 来源异常
     * @throws UserException 用户异常
     */
    public void throwUserException(Exception e) throws UserException {
        throw new UserException(this.message, e);
    }

    /**
     * 抛出UserException异常
     * @throws UserException 用户异常
     */
    public void throwUserException() throws UserException {
        throw new UserException(this.message);
    }
}
