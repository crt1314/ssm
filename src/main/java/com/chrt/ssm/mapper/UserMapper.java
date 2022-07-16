package com.chrt.ssm.mapper;

import com.chrt.ssm.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户类持久层
 */
public interface UserMapper {
    /**
     * 查找所有用户
     * @return 用户列表
     */
    @Results(id = "getAllUser", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "emails", column = "{user_id=id, username=username}", many = @Many(
                    select = "com.chrt.ssm.mapper.EmailMapper.findByUserId", fetchType = FetchType.LAZY
            ))
    })
    @Select("select id, username, password from jfm_user where isValid = 1")
    List<User> getAllUser();
}
