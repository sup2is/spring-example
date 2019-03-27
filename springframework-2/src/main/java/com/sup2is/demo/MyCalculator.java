package com.sup2is.demo;

import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
	
	public int add(int a, int b) {
		System.out.println("### add method 실행");
		return a + b;
	}
	
	public int sub(int a, int b) {
		System.out.println("### sub method 실행");
		return a - b;
	}
	
	public int division(int a, int b) {
		System.out.println("### division method 실행");
		return a / b;
	}
	
	public int multiply(int a, int b) {
		System.out.println("### multiply method 실행");
		
		if(a == 0) {
			throw new IllegalArgumentException();
		}
		
		return a * b;
	}
}

