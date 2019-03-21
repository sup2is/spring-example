package com.sup2is.demo;

public class FooComponentC {

	private String name;
	
    //생성자로 초기화
//	public FooComponentC(String name) {
//		this.name = name;
//	}
	
    //setter 메서드로 초기화
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(FooComponentC.class.getSimpleName() + " : hello world");
	}
	
	public void printName() {
		System.out.println("my name is " + name);
	}
	
}
