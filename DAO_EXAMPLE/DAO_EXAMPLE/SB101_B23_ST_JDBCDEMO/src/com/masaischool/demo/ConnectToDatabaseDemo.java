package com.masaischool.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabaseDemo {
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
			System.out.println("Connection successful");
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(conn != null) {
				//means connection was established
				try {
					conn.close();
					System.out.println("Connection closed!");
				}catch(SQLException ex) {
					ex.printStackTrace();
				}

			}
		}

	}
}
