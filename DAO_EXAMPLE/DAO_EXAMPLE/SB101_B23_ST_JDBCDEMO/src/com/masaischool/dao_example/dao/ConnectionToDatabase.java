package com.masaischool.dao_example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to make connection and close connection with database
 * @author Masai
 */
public class ConnectionToDatabase {
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
	
	/**
	 * Connect to database and return the object of java.sql.Connection interface
	 * @return: java.sql.Connection
	 * @throws SQLException if not able to connect to database due to any reason
	 */
	static Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * close the connection to database specified by the parameter
	 * @param connection: java.sql.Connection
	 * @throws SQLException if not able to close the connection due to any reason
	 */
	static void CloseConnection(Connection connection) throws SQLException {
		if(connection != null)
			connection.close();
	}
}
