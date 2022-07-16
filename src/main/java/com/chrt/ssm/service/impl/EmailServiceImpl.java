package com.chrt.ssm.service.impl;

import com.chrt.ssm.exception.EmailException;
import com.chrt.ssm.service.api.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮箱服务实现类
 */
@Service
@PropertySource("classpath:mail.properties")
@Transactional
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 邮箱发送人信息
     */
    @Value("${email.username}")
    private String systemEmail;

    @Override
    public void sendMail(String to, String subject, String context) throws EmailException {
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom(systemEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            throw new EmailException("Failed to send mail.", e);
        }
    }
}
