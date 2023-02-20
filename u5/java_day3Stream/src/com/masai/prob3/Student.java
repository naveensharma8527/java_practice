package com.masai.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//## Problem 3 :
//
//Create a List of 5 Student objects and from that List get the highest marks
//Student by using Stream API.




public class Student {
		
	int mark;
	
	
	public Student(int mark) {
		this.mark = mark;
	}
	


	public int getMark() {
		return mark;
	}
	
	



	@Override
	public String toString() {
		return "Student [mark=" + mark + "]"+"\n";
	}



	public static void main(String[] args) {
		
		List <Student> list = new ArrayList<>();
		
		list.add(new Student(50));
		list.add(new Student(70));
		list.add(new Student(40));
		list.add(new Student(10));
		list.add(new Student(90));
		
		
		System.out.println(list);
		
//		int higestMarks = list.stream().sorted((s1,s2) -> s2.getMark()-s1.getMark()).collect(Collectors.toList()).get(0).getMark();
		
//		System.out.println("Highest Marks among all student is : "+ higestMarks);
		System.out.println(list.stream().sorted((s1,s2) -> s2.getMark()-s1.getMark()).collect(Collectors.toList()));
	}

}
