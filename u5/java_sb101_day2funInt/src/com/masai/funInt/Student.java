package com.masai.funInt;

import java.util.ArrayList;
import java.util.List;

interface Intr {	
	public List<Student> findStudent(List<Student> stu);
}




public class Student {

	String name;
	int mark;
	public Student(String name, int mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + "]" +"\n";
	}
	
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("naveen", 900));
		students.add(new Student("amit", 400));
		students.add(new Student("vikas", 550));
		students.add(new Student("sachin", 390));
		students.add(new Student("rahul", 490));
		
		System.out.println(students);
		
		Intr it = stds -> {
			List <Student> li = new ArrayList<>();
			stds.forEach(s -> {
				if(s.getMark() > 500) {
					li.add(s);
				}
			});
			return li;
		};
		
	List<Student> finalans = it.findStudent(students);
	
	for(Student s : finalans) {
		System.out.println(s);
	}
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
