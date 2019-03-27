package com.sup2is.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

	@Autowired
	private MyCalculator myCalculator;
	
	@Test
	public void addTest() {
		System.out.println(myCalculator.add(5, 5));
	}
	@Test
	public void subTest() {
		System.out.println(myCalculator.sub(5, 5));
	}
	@Test
	public void divisionTest() {
		System.out.println(myCalculator.division(5, 0));
	}
	@Test
	public void multiplyTest() {
		System.out.println(myCalculator.multiply(0, 5));
	}

}
