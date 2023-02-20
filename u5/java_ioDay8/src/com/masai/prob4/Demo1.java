package com.masai.prob4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//● Write a class Demo1 to Serialize the List of 5 Student objects with proper data into a file studentdata.txt file.
//● Write a class Demo2 in which deserialize the above 
//Student's details from the “studentdata.txt” file and print all student's details using the Lambda expression.
//
//**Note:** The password of the student can’t be serialized.
//
//##

public class Demo1 {

	public static void main(String[] args) throws IOException {
		Address ad1 = new Address("up", "ghaziabad", 121);
		Address ad2 = new Address("uk", "naini", 120);
		Address ad3 = new Address("hp", "manali", 111);
		Address ad4 = new Address("raj", "jaipur", 141);
		Address ad5 = new Address("kar", "banglore", 151);
		
		
		Student st1 = new Student(1, "Naveen", 500, "nav123", ad1);
		Student st2 = new Student(1, "Abhi", 300, "abh21", ad2);
		Student st3 = new Student(1, "vikas", 250, "vi12", ad3);
		Student st4 = new Student(1, "amit", 100, "amit678", ad4);
		Student st5 = new Student(1, "ravi", 150, "ravi651", ad5);
		
		FileOutputStream fos = new FileOutputStream("studentdata.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.writeObject(st3);
		oos.writeObject(st4);
		oos.writeObject(st5);
		
		oos.close();
		
		
		
		
		
		

	}
	
	

}
