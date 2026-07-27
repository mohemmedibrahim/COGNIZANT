package com.cognizant.ormlearn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.cognizant.ormlearn.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {

        System.out.println("Before Method : " + joinPoint.getSignature().getName());

    }

    @After("execution(* com.cognizant.ormlearn.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {

        System.out.println("After Method : " + joinPoint.getSignature().getName());

    }

}