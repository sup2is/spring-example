package com.sup2is.demo;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {
	
    //Spring Bean에 등록된것들중 동일한 타입이 있으면 자동으로 주입해주는 어노테이션
	@Autowired
	private DefaultListableBeanFactory beanFactory;
	
	@Autowired
	private FooComponentC fooComponentC;
	
	@Test
	public void beanCheckTest() {
		for(String name : beanFactory.getBeanDefinitionNames()) {
			System.out.println("Bean name : " + beanFactory.getBean(name).getClass().getName());
		}
		
	}
	
	@Test
	public void fooComponentCTest() {
		fooComponentC.printName();
	}

}
