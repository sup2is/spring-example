package com.sup2is.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CalculationAspect {

	@Before("execution(* com.sup2is.demo.MyCalculator.*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("### " + joinPoint.getSignature().getName() + " : before excute");
	}
	
}
