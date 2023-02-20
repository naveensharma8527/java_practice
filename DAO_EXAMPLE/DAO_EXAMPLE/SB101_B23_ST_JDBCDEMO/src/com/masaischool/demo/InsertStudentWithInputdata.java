package com.masaischool.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class InsertStudentWithInputdata {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//code to load Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Driver class not found, check jar file");
			return;
		}
		
		//code to take input details of student
		System.out.println("Please enter rollNo, name, cgpa and registration date");
		String rollNumber = sc.next();
		String name = sc.next();
		double cgpa = sc.nextDouble();
		LocalDate registrationDate = LocalDate.parse(sc.next());
		
		//you are here means Driver class is loaded
		String url = "jdbc:mysql://localhost/sb101_b23_db1";
		String username = "root";
		String password = "root";
		
		String insertStatement = "INSERT INTO student (roll_number, name, cgpa, registration_date) VALUES ('"+ rollNumber +"', '"+ name +"' , "+ cgpa +", '"+ registrationDate +"')";
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			//you are here means connection is successful
			Statement statement = conn.createStatement();
			if(statement.executeUpdate(insertStatement) > 0) {
				System.out.println("student added successfully");
			}else {
				System.out.println("Something went wrong");
			}
			//once execution of try block is over then connection will be released automatically, no need of finally block
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		sc.close();
	}
}
