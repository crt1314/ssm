package com.chrt.ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 对Mapper类进行切面编程
 */
@Aspect
@Component
public class MapperAspect {
    /**
     * 配置切入点
     */
    @Pointcut("execution(* com.chrt.ssm.mapper.*.*(..))")
    public void pointcut() {}

    /**
     * 配置前置通知
     * @param joinPoint 目标信息类
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("The target-class is " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("The method is " + joinPoint.getSignature().getName());
    }
}
