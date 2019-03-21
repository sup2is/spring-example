package com.sup2is.demo;

import org.springframework.stereotype.Component;

@Component //Spring이 Bean을 초기화 할 때 @Component 가 붙은 클래스를 확인하고 해당 클래스를 Bean으로 등록
public class FooComponentA {

	public void print() {
		System.out.println(FooComponentA.class.getSimpleName() + " : hello world");
	}
	
}
