package com.masai.lambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Incbythousand{
	int incbytho( int s);
}



public class Employee {
	
	 int empId;
	 String name;
	 String address;
	 int salary;
	

	public Employee(int empId, String name, String address, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	




	public int getSalary() {
		return salary;
	}






	public void setSalary(int salary) {
		this.salary = salary;
	}






	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary + "]" +"\n";
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "Naveen", "delhi", 10000));
		employees.add(new Employee(2, "amit", "delhi", 4000));
		employees.add(new Employee(3, "abhi", "delhi", 7000));
		employees.add(new Employee(4, "kunal", "delhi", 3000));
		employees.add(new Employee(5, "shivam", "delhi", 5000));

		
		System.out.println(employees);
		
		Incbythousand it = (s) -> {
			if(s < 5000) {
				s = s+ 1000;
			}
			return s;
		};
		
		for(int i =0;i<employees.size();i++) {
			employees.get(i).setSalary(it.incbytho(employees.get(i).salary));
		}
		
		
		System.out.println(employees);
		
	}
	
	 
	

}
