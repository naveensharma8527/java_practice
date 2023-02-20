package com.masaischool.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentJDBCDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Write code to load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");	//--(1)
			
			//call the getConnectection method using DriverManager class
			String url = "jdbc:mysql://localhost/sb101_b23_db1";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);	//--(2)

			//Create SQL query for inserting the record
			String insertStatement = "INSERT INTO student (roll_number, name, cgpa, registration_date) VALUES('R001', 'ABC', 9.2, CURDATE())";
			
			//get object of statement for this connection
			Statement state = conn.createStatement();
			
			if(state.executeUpdate(insertStatement) > 0) {
				System.out.println("Student added successfully");
			}else {
				System.out.println("Something went wrong");
			}

		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(conn != null) {
				//means connection was established
				try {
					conn.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}

			}
		}
	}
}
