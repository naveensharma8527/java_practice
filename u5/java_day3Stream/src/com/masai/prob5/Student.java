package com.masai.prob5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
	String name;
	int mark;
	
	
	public Student(int mark,String name) {
		this.mark = mark;
		this.name = name;
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
		return "Student [name=" + name + ", mark=" + mark + "]"+"\n";
	}







	@Override
	public int hashCode() {
		return Objects.hash(mark, name);
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return mark == other.mark && Objects.equals(name, other.name);
	}







	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Student> studentsSet = new LinkedHashSet<>();
		
		studentsSet.add(new Student(500, "naveen"));
		studentsSet.add(new Student(600, "kaushal"));
		studentsSet.add(new Student(500, "naveen"));
		studentsSet.add(new Student(400, "ritesh"));
		studentsSet.add(new Student(700, "ravi"));
		studentsSet.add(new Student(300, "amit"));
		studentsSet.add(new Student(900, "sonu"));
		
		System.out.println(studentsSet);
		
		
//		Create a Set of 5 Student objects and from that set filter those students
//		whose marks is less than 500 and put all the filtered Student object inside another Set object.
//		Note: Make sure that there should not be any duplicate Student objects.
		
		
		System.out.println("******************************");
		System.out.println("******************************");
		

//		Set<Student> filteredSet = new LinkedHashSet<>();
		
		List<Student> filteredList = new ArrayList<>(studentsSet);
//		Set<Student> filteredSet=  set.stream().filter(st -> st.getMark()>500);
//		filteredList.stream().filter(st -> st.getMark() > 500);
		
		Set<Student> filteredSet= filteredList.stream().filter(st -> st.getMark() > 500).collect(Collectors.toSet());
		
//		System.out.println(list.stream().sorted((s1,s2) -> s2.getMark()-s1.getMark()).collect(Collectors.toList()));
		System.out.println(filteredSet);
		
		
	}


}
