package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {
    
    @Before("execution(* com.example.demo.repository.UserRepository.findByUserName(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("joinnnnnnnnnnnnnnnnnnnnnnnnnnn1. "+ joinPoint.getSignature().getName());
    }
    
    @After("execution(* com.example.demo.repository.UserRepository.findByUserName(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("joinnnnnnnnnnnnnnnnnnnnnnnnnnn2. "+ joinPoint.getSignature().getName());
    }
}
