package com.sup2is.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component //반드시 Component 등의 Spring Bean으로 등록해야 Aspect가 제대로 적용됨
public class CalculationAspect {

	// com.sup2is.demo.MyCalculator class 내부의 모든 메서드에 실행
	@Before("execution(* com.sup2is.demo.MyCalculator.*(..))") 
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("### " + joinPoint.getSignature().getName() + " : before execute");
	}
	
	// com.sup2is.demo.MyCalculator class 내부의 add 메서드에 실행
	@After("execution(* com.sup2is.demo.MyCalculator.add(..))") 
	public void afterLog(JoinPoint joinPoint) {
		System.out.println("### " + joinPoint.getSignature().getName() +" : after execute");
	}
	
	// com.sup2is.demo.MyCalculator class 내부의 add,division 메서드에 실행
	@AfterReturning(pointcut = "execution(* com.sup2is.demo.MyCalculator.add(..)) ||"
			+ " execution(* com.sup2is.demo.MyCalculator.division(..))" , returning="value")
	public void afterReturning(JoinPoint joinPoint, Integer value) {
		System.out.println("### " + joinPoint.getSignature().getName() +" : after returning execute");
		System.out.println("### value : " + value );
	}
	
	// com.sup2is.demo.MyCalculator class 내부의 division,multiply 메서드에 실행
	@AfterThrowing(pointcut = "execution(* com.sup2is.demo.MyCalculator.division(..)) ||"
			+ " execution(* com.sup2is.demo.MyCalculator.multiply(..))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, ArithmeticException ex) {
		System.out.println("### " + joinPoint.getSignature().getName() +" : afterThrowing execute");
		System.out.println("### " + ex.toString() +" : exception occurred");
	}
	
	// com.sup2is.demo.MyCalculator class 내부의 sub 메서드에 실행
	@Around("execution(* com.sup2is.demo.MyCalculator.sub(..))")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("### " + joinPoint.getSignature().getName() + " : before around excute");
		try {
			Object result = joinPoint.proceed();
			
			if(Integer.parseInt(result.toString()) == 0) {
				return -1;
			}
			
			return result;
		}finally {
			System.out.println("### " + joinPoint.getSignature().getName() + " : after around excute");
		}
	}
	
}
