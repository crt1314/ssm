package com.chrt.ssm.service.impl;

import com.chrt.ssm.exception.EmailException;
import com.chrt.ssm.mapper.EmailMapper;
import com.chrt.ssm.service.api.EmailService;
import com.chrt.ssm.util.EmailExceptionEnumeration;
import com.chrt.ssm.util.EmailExceptionEnumerationWrapper;
import com.chrt.ssm.util.EmailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
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

    /**
     * 注入EmailMapper
     */
    @Autowired
    private EmailMapper emailMapper;
    /**
     * 注入邮件发送类
     */
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
            EmailExceptionEnumerationWrapper.wrapperEmailException(EmailExceptionEnumeration.EMAIL_FAILED_TO_SET_MESSAGE, e);
        } catch (MailException e) {
            EmailExceptionEnumerationWrapper.wrapperEmailException(EmailExceptionEnumeration.EMAIL_FAILED_TO_SEND, e);
        }
    }

    @Override
    public void insertMail(String email, Integer user_id, String username) throws EmailException {
        if (EmailHelper.isEmailMeetsRequirements(email)) {
            Integer count = emailMapper.insertEmail(email, username, user_id);
            if (count == 0) {
                EmailExceptionEnumerationWrapper.wrapperEmailException(EmailExceptionEnumeration.EMAIL_FAILED_TO_INSERT);
            }
        } else {
            EmailExceptionEnumerationWrapper.wrapperEmailException(EmailExceptionEnumeration.EMAIL_FAILED_TO_MEET_REQUIREMENTS);
        }
    }
}
