package com.chrt.ssm.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.FileUrlResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

/**
 * Spring配置类
 * 支持注解扫描
 * 支持事务管理
 * 支持切面编程
 */
@Configuration
@ComponentScan(basePackages = {"com.chrt.ssm.service", "com.chrt.ssm.aspect"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {

    /**
     * 获取邮件发送类
     * @return 邮件发送类
     */
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        try (InputStream is = SpringConfig.class.getClassLoader().getResourceAsStream("mail.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            Properties javaMailProperties = new Properties();
            String protocol = properties.getProperty("email.protocol");
            javaMailProperties.setProperty("mail." + protocol + ".auth", properties.getProperty("email.auth"));
            javaMailProperties.setProperty("mail." + protocol + ".timeout", properties.getProperty("email.timeout"));
            javaMailSender.setProtocol(protocol);
            javaMailSender.setHost(properties.getProperty("email.host"));
            javaMailSender.setPort(Integer.parseInt(properties.getProperty("email.port")));
            javaMailSender.setUsername(properties.getProperty("email.username"));
            javaMailSender.setPassword(properties.getProperty("email.password"));
            javaMailSender.setDefaultEncoding(properties.getProperty("email.defaultEncoding"));
            javaMailSender.setJavaMailProperties(javaMailProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaMailSender;
    }

    /**
     * 定义Mapper扫描器
     * @return Mapper扫描器
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.chrt.ssm.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    /**
     * 定义MyBatis工厂
     * @param dataSource 数据源
     * @return 工厂类
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        URL configLocation = SpringConfig.class.getClassLoader().getResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(new FileUrlResource(Objects.requireNonNull(configLocation)));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    /**
     * 事务管理
     * @param dataSource 数据源
     * @return 事务管理器
     */
    @Bean
    public TransactionManager getTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 定义数据源
     * @return 数据源
     */
    @Bean
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try (InputStream is = SpringConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
