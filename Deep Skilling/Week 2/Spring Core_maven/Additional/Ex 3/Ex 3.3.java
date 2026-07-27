package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        System.out.println("Method started: " + joinPoint.getSignature());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println("Method ended: " + joinPoint.getSignature());

        System.out.println("Execution Time: " + (endTime - startTime) + " ms");

        return result;
    }

}