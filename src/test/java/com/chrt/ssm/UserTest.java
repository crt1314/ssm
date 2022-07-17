package com.chrt.ssm;

import com.chrt.ssm.config.SpringConfig;
import com.chrt.ssm.mapper.UserMapper;
import com.chrt.ssm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class}, loader = AnnotationConfigContextLoader.class)
public class UserTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUser() {
        userMapper.getAllUser().forEach(System.out::println);
    }

    @Test
    public void testUser2() {
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }
}
