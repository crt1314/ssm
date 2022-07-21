package com.chrt.ssm.service.impl;

import com.chrt.ssm.exception.UserException;
import com.chrt.ssm.mapper.UserMapper;
import com.chrt.ssm.pojo.User;
import com.chrt.ssm.service.api.UserService;
import com.chrt.ssm.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现类
 */
@Service
@Transactional(rollbackFor = {UserException.class})
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) throws UserException {
        UserHelper.addUser(user, userMapper);
    }

    @Override
    public void checkUserIfExists(User user) throws UserException {
        UserHelper.checkUser(user, userMapper);
    }
}
