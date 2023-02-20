package com.masaischool.demo;

public class A {
	static {
		System.out.println("Inside static block-1");
	}
	
	static {
		System.out.println("Inside static block-2");
	}
	
	{
		System.out.println("Inside non-static block-1");
	}
	
	{
		System.out.println("Inside non-static block-2");
	}
	
	A(){
		System.out.println("Inside constructor");
	}
	
	void fun() {
		System.out.println("Inside fun");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main");
		A a = new A();
		a.fun();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		A a1 = new A();
	}
}
