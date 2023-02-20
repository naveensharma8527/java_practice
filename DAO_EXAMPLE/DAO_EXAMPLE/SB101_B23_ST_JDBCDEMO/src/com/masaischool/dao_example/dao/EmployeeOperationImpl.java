package com.masaischool.dao_example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dao_example.dto.Employee;
import com.masaischool.dao_example.dto.EmployeeImpl;
import com.masaischool.dao_example.exception.NoEmployeeFoundException;
import com.masaischool.dao_example.exception.SomeThingWrongException;
import com.mysql.cj.xdevapi.PreparableStatement;

public class EmployeeOperationImpl implements EmployeeOperation {

	@Override
	public void addEmployee(Employee ex) throws SomeThingWrongException {
		Connection connection = null;
		try {
			//connect to database
			connection = ConnectionToDatabase.connectToDatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO employee (employee_id, employee_name, salary_in_lpa, date_of_joining) VALUES (?, ?, ?, ?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setString(1, ex.getEmployeeId());
			ps.setString(2, ex.getEmployeeName());
			ps.setDouble(3, ex.getSalaryinLPA());
			ps.setDate(4, Date.valueOf(ex.getDateOfJoining()));
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				ConnectionToDatabase.CloseConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}

	@Override
	public void updateEmployeeDetails(Employee ex) throws SomeThingWrongException {
		Connection connection = null;
		try {
			//connect to database
			connection = ConnectionToDatabase.connectToDatabase();
			//prepare the query
			String UPDATE_QUERY = "UPDATE employee SET employee_name = ?, salary_in_lpa = ?, date_of_joining = ? WHERE employee_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, ex.getEmployeeName());
			ps.setDouble(2, ex.getSalaryinLPA());
			ps.setDate(3, Date.valueOf(ex.getDateOfJoining()));
			ps.setString(4, ex.getEmployeeId());
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				ConnectionToDatabase.CloseConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}

	@Override
	public void deleteEmployee(String employeeId) throws SomeThingWrongException {
		Connection connection = null;
		try {
			//connect to database
			connection = ConnectionToDatabase.connectToDatabase();
			//prepare the query
			String DELETE_QUERY = "DELETE FROM employee WHERE employee_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, employeeId);
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				ConnectionToDatabase.CloseConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}

	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}
	
	private List<Employee> getEmployeeListFromResultSet(ResultSet resultSet) throws SQLException{
		List<Employee> list = new ArrayList<>();
		while(resultSet.next()) {
			//Create an object of Employee
			Employee emp = new EmployeeImpl();
			emp.setEmployeeId(resultSet.getString("employee_id"));
			emp.setEmployeeName(resultSet.getString("employee_name"));
			emp.setSalaryinLPA(resultSet.getDouble("salary_in_lpa"));
			emp.setDateOfJoining(resultSet.getDate("date_of_joining").toLocalDate());
			list.add(emp);
		}
		return list;
	}
	
	@Override
	public List<Employee> getEmployeeList() throws SomeThingWrongException, NoEmployeeFoundException {
		Connection connection = null;
		List<Employee> list = null;
		try {
			//connect to database
			connection = ConnectionToDatabase.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM employee";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoEmployeeFoundException("");
			}
			
			list = getEmployeeListFromResultSet(resultSet);
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				ConnectionToDatabase.CloseConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Employee getEmployeeById(String employeeId) throws SomeThingWrongException, NoEmployeeFoundException {
		Connection connection = null;
		Employee emp = null;
		try {
			//connect to database
			connection = ConnectionToDatabase.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM employee WHERE employee_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, employeeId);
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoEmployeeFoundException(" for this employee id");
			}
			resultSet.next();
			emp = new EmployeeImpl();
			emp.setEmployeeId(resultSet.getString("employee_id"));
			emp.setEmployeeName(resultSet.getString("employee_name"));
			emp.setSalaryinLPA(resultSet.getDouble("salary_in_lpa"));
			emp.setDateOfJoining(resultSet.getDate("date_of_joining").toLocalDate());
			
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				ConnectionToDatabase.CloseConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) throws SomeThingWrongException, NoEmployeeFoundException {
		Connection connection = null;
		List<Employee> list = null;
		try {
			//connect to database
			connection = ConnectionToDatabase.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM employee WHERE employee_name LIKE '%?%'";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, name);
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoEmployeeFoundException(" for this name");
			}
			
			list = getEmployeeListFromResultSet(resultSet);
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				ConnectionToDatabase.CloseConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		// TODO Auto-generated method stub
		return list;
	}

}
