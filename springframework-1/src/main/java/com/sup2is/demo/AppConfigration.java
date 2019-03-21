package com.sup2is.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //마찬가지로 Spring이 Bean을 초기화 할 때 @Configuration 붙은 클래스를 확인
public class AppConfigration {
	
	@Bean  //@Configuration 밑에 @Bean 어노테이션도 Spring Bean으로 등록
	public FooComponentB componentB() {
		return new FooComponentB();
	}

}
