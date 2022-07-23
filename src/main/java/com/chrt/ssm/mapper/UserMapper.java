package com.chrt.ssm.mapper;

import com.chrt.ssm.pojo.User;
import org.apache.ibatis.annotations.*;
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
    @Results(id = "getUser", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "emails", column = "{user_id=id, username=username}", many = @Many(
                    select = "com.chrt.ssm.mapper.EmailMapper.findByUserId", fetchType = FetchType.LAZY
            ))
    })
    @Select("select id, username, password from jfm_user where isValid = 1")
    List<User> getAllUser();

    /**
     * 根据用户唯一标识查找用户
     * @param id 用户唯一标识
     * @return 用户信息
     */
    @ResultMap("getUser")
    @Select("select id, username, password from jfm_user where id = #{id} and isValid = 1")
    User getUserById(Integer id);

    /**
     * 添加用户信息
     * @param user 用户
     * @return 表数据影响条数
     */
    @Insert("insert into jfm_user values(null, #{username}, sha(#{password}), now(), now(), 1, null)")
    Integer addUser(User user);

    /**
     * 删除用户
     * @param id 用户唯一标识
     * @return 表数据影响条数
     */
    @Update("update jfm_user set isValid = 0, gmt_modified = now() where id = #{id} and isValid = 1")
    Integer deleteUserById(Integer id);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 表数据影响条数
     */
    @Update("update jfm_user set gmt_modified = now() where id = #{id} and isValid = 1")
    Integer updateUser(User user);

    @Select("select count(username) from jfm_user where username = #{username} and isValid = 1")
    Integer getUserByUsername(String username);
}
