package com.chrt.ssm.service.api;

import com.chrt.ssm.exception.EmailException;

/**
 * 邮箱服务接口
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param to 收件信箱
     * @param subject 邮件标题
     * @param context 邮件内容
     * @throws EmailException 邮件信息设置失败或发送失败异常
     */
    void sendMail(String to, String subject, String context) throws EmailException;

    /**
     * 添加邮箱信息
     * @param email 邮箱信息
     * @param choice 邮箱类型
     * @param user_id 用户唯一标识
     * @param username 用户名称
     * @throws EmailException 邮箱添加失败、格式不符、格式选项错误异常
     */
    void insertMail(String email, String choice, Integer user_id, String username) throws EmailException;

    /**
     * 修改邮箱信息
     * @param email 邮箱信息
     * @param choice 邮箱类型
     * @param user_id 用户唯一标识
     * @param username 用户名称
     * @throws EmailException 邮箱修改失败、格式不符、格式选项错误异常
     */
    void updateMail(String email, String choice, Integer user_id, String username) throws EmailException;

    /**
     * 删除邮箱信息
     * @param email 邮箱信息
     * @param choice 邮箱类型
     * @param user_id 用户唯一标识
     * @param username 用户名称
     * @throws EmailException 邮箱删除失败、格式不符、格式选项错误异常
     */
    void deleteMail(String email, String choice, Integer user_id, String username) throws EmailException;

    /**
     * 删除邮箱信息
     * @param user_id 用户唯一标识
     * @throws EmailException 邮箱删除失败异常
     */
    void deleteMailWithoutHelp(Integer user_id) throws EmailException;
}
