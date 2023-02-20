package com.masai.prob2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Create a ThreadPool of 2 threads, submit the 6 tasks using Callable,
//and perform the following activity from each task:
//● Each task should get the student object (roll, name, marks) and return
//the result of the Student with their name, for example: if marks are greater
//than 500 then return Pass or return fail.
//Note: Supply the number to the Callable task through the constructor of
//the Callable task class.


class Student{
	int roll;
	String name;
	int mark;
	
	public Student(int roll, String name, int mark) {
		super();
		this.roll = roll;
		this.name = name;
		this.mark = mark;
	}
	
	

	public int getRoll() {
		return roll;
	}



	public void setRoll(int roll) {
		this.roll = roll;
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
		return "Student [roll=" + roll + ", name=" + name + ", mark=" + mark + "]";
	}
	
	
}



public class CallableEx implements Callable<String> {
	
	Student st;
	
	
	
	public CallableEx(Student st) {
		this.st = st;
	}





	@Override
	public String call() throws Exception {
		if(st.getMark() < 500) {
			return st.getName() +"   " + "Fail";
		}else {
			return st.getName() +"   " + "Pass";
		}
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Student [] stArr = {
				new Student(1, "Naveen", 600),
				new Student(1, "Abhishek", 500),
				new Student(1, "Kaushal", 900),
				new Student(1, "Vikas", 400),
				new Student(1, "Amit", 100),
				new Student(1, "Deepak", 700),
				};
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		for(Student stu : stArr) {
			CallableEx cx = new CallableEx(stu);
			Future<String> f = es.submit(cx);
			System.out.println(f.get());
		}
		

		

	}

	

}
