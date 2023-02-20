package com.masaischool.dao_example.ui;

import java.time.LocalDate;
import java.util.List;

import com.masaischool.dao_example.dao.EmployeeOperation;
import com.masaischool.dao_example.dao.EmployeeOperationImpl;
import com.masaischool.dao_example.dto.Employee;
import com.masaischool.dao_example.dto.EmployeeImpl;
import com.masaischool.dao_example.exception.NoEmployeeFoundException;
import com.masaischool.dao_example.exception.SomeThingWrongException;

public class Main {
	public static void main(String[] args) {
		EmployeeOperation empOper = new EmployeeOperationImpl();
		try {
			Employee emp = new EmployeeImpl("E001", "ABC", 7.2, LocalDate.parse("2023-01-01"));
			empOper.addEmployee(emp);
			System.out.println("Employee addedd successfully");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			List<Employee> employeeList = empOper.getEmployeeList();
			employeeList.forEach(System.out::println);
		}catch(SomeThingWrongException | NoEmployeeFoundException ex) {
			System.out.println(ex);
		}

	}
}
