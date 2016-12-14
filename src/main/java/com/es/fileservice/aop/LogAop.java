package com.es.fileservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by LHL on 2016/12/14.
 */
@Aspect
@Component
public class LogAop {
    @Before("execution(* com.es.fileservice.controller.*.* (..))")
    public void logBefore(){
        System.out.println("=============>before===============");
    }
    @AfterReturning(value = "execution(* com.es.fileservice.controller.*.* (..))")
    public void LogController(JoinPoint joinPoint){
        System.out.println("complete:"+joinPoint);
    }
}
