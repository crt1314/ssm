package com.chrt.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC配置类
 * 支持注解扫描
 */
@Configuration
@ComponentScan({"com.chrt.ssm.controller"})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    /**
     * 指定映射地址
     * @param registry 配置映射前后缀
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    /**
     * 处理静态资源
     * @param configurer 静态资源处理配置类
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
