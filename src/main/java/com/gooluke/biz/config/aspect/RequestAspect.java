package com.gooluke.biz.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 咕噜科
 * ClassName: RequestAspect
 * date: 2023-08-18 20:21
 * Description:
 * version 1.0
 */
@Component
@Aspect
public class RequestAspect {

    //@Pointcut("execution(* com.gooluke.biz.server.controller.*.*(..))")
    @Pointcut("@annotation(com.gooluke.common.annotation.RequestCheck)")
    public void myPointCut() {}

    @Before("myPointCut()")
    public void before() {
        System.out.println("这是前置通知");
    }

    @AfterReturning("myPointCut()")
    public void AfterReturning() {
        System.out.println("这是后置通知");
    }

    @Around("myPointCut()")
    public void Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("这是环绕通知之前");
        joinPoint.proceed();
        System.out.println("这是环绕通知之后");
    }

    @AfterThrowing("myPointCut()")
    public void AfterThrowing() {
        System.out.println("这是异常通知");
    }

    @After("myPointCut()")
    public void After() {
        System.out.println("这是最终通知");
    }
}
