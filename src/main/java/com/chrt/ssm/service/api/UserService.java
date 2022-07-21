package com.chrt.ssm.service.api;

import com.chrt.ssm.exception.UserException;
import com.chrt.ssm.pojo.User;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 注册用户
     * @param user 用户信息
     * @throws UserException 用户异常
     */
    void registerUser(User user) throws UserException;

    /**
     * 查看用户是否存在
     * @param user 用户信息
     */
    void checkUserIfExists(User user) throws UserException;
}
