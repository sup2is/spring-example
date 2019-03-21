package com.sup2is.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication //@SpringBootApplication 은 @ComponentScan 을 포함하기 때문에 package 기반으로 Bean을 Scan해줍니다.
@ImportResource({"classpath:spring-context.xml"}) //Spring이 Bean을 초기화할때 xml이 어디있는지 모르니 반드시 명시해줘야 xml방식으로 Bean이 올라가요
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
