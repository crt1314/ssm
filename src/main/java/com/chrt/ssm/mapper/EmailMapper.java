package com.chrt.ssm.mapper;

import com.chrt.ssm.pojo.Email;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 邮箱类持久层
 */
public interface EmailMapper {
    /**
     * 根据用户唯一标识查找邮箱
     * @param user_id 用户唯一标识
     * @param username 用户账号
     * @return 邮箱列表
     */
    @Select(
        "select id, AES_DECRYPT(email, #{username}) as email " +
                "from jfm_email " +
                "where isValid = 1 and user_id = #{user_id}"
    )
    List<Email> findByUserId(@Param("user_id") Integer user_id, @Param("username") String username);

    /**
     * 添加邮箱信息
     * @param email 邮箱信息
     * @param username 用户账号
     * @param user_id 用户唯一标识
     * @param email_type 邮箱类型
     * @return 表数据受影响条数
     */
    @Insert("insert into jfm_email " +
            "values(null, AES_ENCRYPT(#{email}, #{username}), #{user_id}, #{email_type}, now(), now(), 1)")
    Integer insertEmail(
            @Param("email") String email,
            @Param("username") String username,
            @Param("user_id") Integer user_id,
            @Param("email_type") Integer email_type
    );

    /**
     * 更新邮箱信息
     * @param email 邮箱信息
     * @param username 用户名称
     * @param user_id 用户唯一标识
     * @param email_type 邮箱格式
     * @return 表数据受影响条数
     */
    @Update("update jfm_email " +
            "set email = AES_ENCRYPT(#{email}, #{username}), gmt_modified = now() " +
            "where user_id = #{user_id} and email_type = #{email_type} and isValid = 1")
    Integer updateEmail(
            @Param("email") String email,
            @Param("username") String username,
            @Param("user_id") Integer user_id,
            @Param("email_type") Integer email_type
    );

    /**
     * 删除邮箱信息
     * @param email 邮箱信息
     * @param username 用户名称
     * @param user_id 用户唯一标识
     * @param email_type 邮箱格式
     * @return 表数据受影响条数
     */
    @Update("update jfm_email " +
            "set gmt_modified = now(), isValid = 0 " +
            "where user_id = #{user_id} and email_type = #{email_type} and isValid = 1 " +
            "and AES_DECRYPT(email, #{username}) = #{email}")
    Integer deleteEmail(
            @Param("email") String email,
            @Param("username") String username,
            @Param("user_id") Integer user_id,
            @Param("email_type") Integer email_type
    );
}
