package com.masaischool.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class PreparedStatementExample {
	//you are here means Driver class is loaded
	static final String url = "jdbc:mysql://localhost/sb101_b23_db1";
	static final String username = "root";
	static final String password = "root";
	
	static {
		//code to load Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Driver class not found, check jar file");
		}
	}
	
	static Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	static void CloseConnection(Connection connection) throws SQLException {
		if(connection != null)
			connection.close();
	}
	
	static boolean updateStudentDetails(String rollNumber, String name, double cgpa, LocalDate registrationDate) throws SQLException {
		//make connection
		Connection connection = connectToDatabase();
		
		String updateStatement = "UPDATE student SET name = ?, cgpa = ?, registration_date = ? WHERE roll_number = ?";
		
		//you are here means connection is successful
		PreparedStatement prepStatement = connection.prepareStatement(updateStatement);

		//its time to fill the user input in the query
		prepStatement.setString(1, name);
		prepStatement.setDouble(2, cgpa);
		prepStatement.setDate(3, Date.valueOf(registrationDate));
		prepStatement.setString(4, rollNumber);

		//execute the update statement and get the number of records affected in the variable result
		int result = prepStatement.executeUpdate();
		
		//connection closing
		CloseConnection(connection);
		
		//return true if one or more record is updated, false otherwise
		return result > 0?true:false;
	}
	
	static boolean deleteStudentDetails(String rollNumber) throws SQLException {
		//make connection
		Connection connection = connectToDatabase();
		
		//make the query
		String updateStatement = "DELETE FROM student WHERE roll_number = ?";
		
		//you are here means connection is successful
		PreparedStatement prepStatement = connection.prepareStatement(updateStatement);
		
		//its time to fill the user input in the query
		prepStatement.setString(1, rollNumber);

		//execute the query
		int result = prepStatement.executeUpdate();
			
		//connection closing
		CloseConnection(connection);
		
		//return true if one or more record is updated, false otherwise
		return result > 0?true:false;
	}
	
	static String getStudentData() throws SQLException {
		//make connection
		Connection connection = connectToDatabase();
		
		String selectStatement = "SELECT roll_number, name, cgpa, registration_date FROM student";
		PreparedStatement statement = connection.prepareStatement(selectStatement);
		ResultSet resultSet = statement.executeQuery();
		
		StringBuilder studentDetails = new StringBuilder();
		
		//the cursor is before the first record
		if(!resultSet.next()) {
			//no record in the table student
			studentDetails.append("No student found");
		}else {
			do {
				//the cursor is now on the record-1,2,3
				String recordInfo = resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getDouble(3) + ", " + resultSet.getDate(4) + "\n";
				studentDetails.append(recordInfo);
			}while(resultSet.next());
		}
		
		//connection closing
		CloseConnection(connection);
		return studentDetails.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println(getStudentData());			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

		int choice;
		System.out.println("Enter selection\n 1. Update Student Details\n2. Delete Student");
		choice = sc.nextInt();
		if(choice == 1) {
			try {
				//code to take input details of student
				System.out.println("Please enter rollNo, name, cgpa and registration date");
				String rollNumber = sc.next();
				String name = sc.next();
				double cgpa = sc.nextDouble();
				LocalDate registrationDate = LocalDate.parse(sc.next());
				
				//update operation
				if(updateStudentDetails(rollNumber, name, cgpa, registrationDate)) {
					System.out.println("Student updated successfully");
				}else {
					System.out.println("No updation, sth went wrong");
				}				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}

		}else if(choice == 2) {
			//code to take input details of student
			System.out.print("Please enter rollNo ");
			String rollNumber = sc.next();
			//delete operation
			try {
				if(deleteStudentDetails(rollNumber)) {
					System.out.println("Student deleted successfully");
				}else {
					System.out.println("No delete, sth went wrong");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("invalid Selection");
		}
		sc.close();
	}
}
