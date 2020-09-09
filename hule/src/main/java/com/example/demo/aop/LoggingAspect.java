package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//	
//	@Before("execution(* com.example.demo.repository.UserRepository.findByUserName(..))")
//	public void logBeforeFindByUserName(JoinPoint joinPoint) {
//		System.out.println("logging before...... "+ joinPoint.getSignature().getName());
//	}
//	
//	@After("execution(* com.example.demo.repository.UserRepository.findByUserName(..))")
//	public void logAfterFindByUserName(JoinPoint joinPoint) {
//		System.out.println("logging After...... "+ joinPoint.getSignature().getName());
//	}
	
}
