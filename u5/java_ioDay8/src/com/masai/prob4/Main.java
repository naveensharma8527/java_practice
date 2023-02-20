package com.masai.prob4;

import java.io.Serializable;

//● Write a class Demo1 to Serialize the List of 5 Student objects with proper data into a file studentdata.txt file.
//● Write a class Demo2 in which deserialize the above 
//Student's details from the “studentdata.txt” file and print all student's details using the Lambda expression.
//
//**Note:** The password of the student can’t be serialized.
//
//##

class Address implements Serializable{
		String state;
		String city;
		int pincode;
		
		public Address(String state, String city, int pincode) {
			super();
			this.state = state;
			this.city = city;
			this.pincode = pincode;
		}

		@Override
		public String toString() {
			return "Address [state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
		}
		
		
		
}
class Student implements Serializable{
	int roll;
	String name; 
	int marks; 
	transient String Password; 
	Address address;
	public Student(int roll, String name, int marks, String password, Address address) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		Password = password;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + ", address=" + address + "]";
	}
	
}





public class Main {

	public static void main(String[] args) {
		

	}

}
