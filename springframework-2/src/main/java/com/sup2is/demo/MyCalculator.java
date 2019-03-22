package com.sup2is.demo;

import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public double division(double a, double b) {
		return a / b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
}

