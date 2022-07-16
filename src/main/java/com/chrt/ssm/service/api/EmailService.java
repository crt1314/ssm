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
     * @throws EmailException 邮件发送失败异常
     */
    void sendMail(String to, String subject, String context) throws EmailException;
}
