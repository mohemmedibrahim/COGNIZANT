package com.library.aspect;


import org.aspectj.lang.JoinPoint;



public class LoggingAspect {



    public void beforeMethod(JoinPoint joinPoint) {


        System.out.println("Before method execution : " 
        + joinPoint.getSignature());


    }




    public void afterMethod(JoinPoint joinPoint) {


        System.out.println("After method execution : " 
        + joinPoint.getSignature());


    }



}