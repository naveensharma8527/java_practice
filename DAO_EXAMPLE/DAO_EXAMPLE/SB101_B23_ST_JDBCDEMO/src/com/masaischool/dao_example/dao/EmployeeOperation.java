package com.masaischool.dao_example.dao;

import java.util.List;

import com.masaischool.dao_example.dto.Employee;
import com.masaischool.dao_example.exception.NoEmployeeFoundException;
import com.masaischool.dao_example.exception.SomeThingWrongException;

public interface EmployeeOperation {
	/**
	 * Add details of employee to database specified in parameter object
	 * @param ex: Employee
	 * @throws SomeThingWrongException if some internal problem occurred
	 */
	public void addEmployee(Employee ex) throws SomeThingWrongException;
	/**
	 * Update details of employee to database specified in parameter object
	 * @param ex: Employee
	 * @throws SomeThingWrongException if some internal problem occurred
	 */
	public void updateEmployeeDetails(Employee ex) throws SomeThingWrongException;
	/**
	 * Delete employee from database specified by parameter employee id
	 * @param employeeId: String
	 * @throws SomeThingWrongException if some internal problem occurred
	 */
	public void deleteEmployee(String employeeId) throws SomeThingWrongException;
	/**
	 * return list of employee from database
	 * @return: List<Employee>
	 * @throws SomeThingWrongException if some internal problem occurred
	 * @throws NoEmployeeFoundException if no employee found
	 */
	public List<Employee> getEmployeeList() throws SomeThingWrongException, NoEmployeeFoundException;
	
	/**
	 * return the Employee object for specified EmployeeId
	 * @param employeeId: String
	 * @return: Employee
	 * @throws SomeThingWrongException if some internal problem occurred
	 * @throws NoEmployeeFoundException if no employee found for given employee id
	 */
	public Employee getEmployeeById(String employeeId) throws SomeThingWrongException, NoEmployeeFoundException;
	
	/**
	 * return the list of employee matching to the name specified bt parameter
	 * @param name: String
	 * @return: List<Employee>
	 * @throws SomeThingWrongException if some internal problem occurred
	 * @throws NoEmployeeFoundException if no employee found for given name
	 */
	public List<Employee> getEmployeeByName(String name) throws SomeThingWrongException, NoEmployeeFoundException;
}
