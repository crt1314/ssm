package com.chrt.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * SpringMVC配置类
 * 支持注解扫描
 */
@Configuration
@ComponentScan({"com.chrt.ssm.controller"})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置Thymeleaf模板解析器
     * @return Thymeleaf模板解析器
     */
    @Bean
    public SpringResourceTemplateResolver getSpringTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setPrefix("/WEB-INF/templates/");
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setTemplateMode("HTML5");
        springResourceTemplateResolver.setCacheable(false);
        springResourceTemplateResolver.setCharacterEncoding("UTF-8");
        return springResourceTemplateResolver;
    }

    /**
     * 配置模板引擎
     * @param springResourceTemplateResolver Thymeleaf模板解析器
     * @return 模板引擎
     */
    @Bean
    public SpringTemplateEngine getSpringTemplateEngine(SpringResourceTemplateResolver springResourceTemplateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
        springTemplateEngine.setEnableSpringELCompiler(true);
        return springTemplateEngine;
    }

    /**
     * 配置Thymeleaf视图解析器
     * @param springTemplateEngine 模板引擎
     * @return 视图解析器
     */
    @Bean
    public ThymeleafViewResolver getThymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
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
