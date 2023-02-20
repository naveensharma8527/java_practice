package com.masai.prob3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//Create a ThreadPool of 3 Threads, and submit the task using Method Reference using Callable.
//
//and perform the following activity from each task:
//
//Use the below method for method reference.
//
//```java
//public Employee xFun() {
//	
//	}
//```
//
//Using the Constructor of MyCallable class accept one Student and convert it into an Employee and 
//return the Employee object if the marks of the given student are between 300 and 500 else return null.



class Student{
	String name;
	int mark;
	public Student(String name, int mark) {
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
		return "Student [name=" + name + ", mark=" + mark + "]";
	}
	
}
class Employee{
	String name;

	public Employee(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	
}


class MyCallable {
	
	Student stu;

	public MyCallable(Student stu) {
		this.stu = stu;
	}
	
	public Employee xFun() {
		if(stu.getMark() > 300 && stu.getMark() < 500) {
			return new Employee(stu.getName());
		}else {
			return null;
		}
	}
	
	
	
}





public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Student st1 = new Student("Naveen", 400);
		Student st2 = new Student("ABhi", 300);
		Student st3 = new Student("Shivam", 450);
		Student st4 = new Student("Irshad", 350);
		Student st5 = new Student("Anuj", 600);
		
		
		MyCallable mc1 = new MyCallable(st1);
		MyCallable mc2 = new MyCallable(st2);
		MyCallable mc3 = new MyCallable(st3);
		MyCallable mc4 = new MyCallable(st4);
		MyCallable mc5 = new MyCallable(st5);
		
		
		MyCallable [] mcArr = {mc1,mc2,mc3,mc4,mc5};
		
		
		ExecutorService es =  Executors.newFixedThreadPool(3);
		
		for(MyCallable mc : mcArr) {
			Callable<Employee> callable = mc::xFun;
			Future<Employee> f = es.submit(callable);
			System.out.println(f.get());
		}
		
		
		
		

	}

}
