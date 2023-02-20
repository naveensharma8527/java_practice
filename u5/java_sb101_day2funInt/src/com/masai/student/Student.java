package com.masai.student;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Student {
	String name;
	int mark;
	public Student(String name, int mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + "]"+"\n";
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
	
	
	public static Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap){
		Map <String,Student> SortedMap = new LinkedHashMap<>();
		
		List<Map.Entry<String, Student>> list = new LinkedList<>(originalMap.entrySet());
		
		Collections.sort(list,(o1,o2) -> {
			return o1.getValue().getName().compareTo(o2.getValue().getName());
		});
		for(Map.Entry<String, Student> ent : list) {
			SortedMap.put(ent.getKey(), ent.getValue());
		}
		
		return SortedMap;
	};
	
	
	public static void main(String[] args) {
//		public Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap);
		
		Student s1  = new Student("naveen", 400);
		Student s2  = new Student("amit", 450);
		Student s3  = new Student("vikas", 300);
		Student s4  = new Student("roshan", 200);
		Student s5  = new Student("kamal", 250);
		
		
		Map <String,Student> map = new LinkedHashMap<>();
		
		map.put("india", s1);
		map.put("america", s2);
		map.put("france", s3);
		map.put("japan", s4);
		map.put("australia", s5);
		
		System.out.println(map);
		
//		List<Map.Entry<String, Student>> list = new LinkedList<>(map.entrySet());
//		System.out.println(list);
//		
//		Collections.sort(list, (o1,o2) -> {
//			return o1.getValue().getName().compareTo(o2.getValue().getName());
//		});
		
		System.out.println("**************************************");
		System.out.println("**************************************");
		
		System.out.println(sortMapUsingStudentName(map)); 
		
		
		
	}
}
