package com.masai.funInt;

@FunctionalInterface
interface Demo{
public int convetStringToNumber(String s);
}



public class MethodRefDemo {

	public static void main(String[] args) {
		
		Demo dm = Integer::parseInt;
		
		System.out.println(dm.convetStringToNumber("23"));

	}

}
