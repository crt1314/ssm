package com.chrt.ssm;

import com.chrt.ssm.config.SpringConfig;
import com.chrt.ssm.mapper.EmailMapper;
import com.chrt.ssm.service.api.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class}, loader = AnnotationConfigContextLoader.class)
@PropertySource("classpath:mail.properties")
public class EmailTest {
    @Value(("${email.username}"))
    private String to;

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private EmailService emailService;

    @Test
    public void testService() {
        emailService.updateMail("123456@qq.com", "QQ", 1, "root");
    }
}
