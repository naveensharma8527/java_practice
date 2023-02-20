package com.masai.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

	 int roll;
	 String name;
	 String email;
	 int marks;
	
	
	
	
	
	
	public Student(int roll, String name, String email, int marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.marks = marks;
	}
	






	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public int getMarks() {
		return marks;
	}







	public void setMarks(int marks) {
		this.marks = marks;
	}







	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", marks=" + marks + "]"+"\n";
	}






	public static void main(String[] args) {

		
		
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "naveen", "gmail", 90));
		students.add(new Student(2, "amit", "gmail", 80));
		students.add(new Student(3, "abhi", "gmail", 95));
		students.add(new Student(4, "kunal", "gmail", 70));
		students.add(new Student(5, "shivam", "gmail", 60));
		
		
		System.out.println(students);
		
		Collections.sort(students,(s1,s2) -> {
			return s1.getName().compareTo(s2.getName());
		} );
		
		System.out.println(students);
		
	}

}
