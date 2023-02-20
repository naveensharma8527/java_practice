package com.masaischool.dao_example.dto;

import java.time.LocalDate;

public interface Employee {
	/**
	 * return employee id of the calling employee object
	 * @return: String
	 */
	public String getEmployeeId();
	/**
	 * sets the employee id for the calling employee object
	 * @param employeeId: String
	 */
	public void setEmployeeId(String employeeId);
	/**
	 * return the name of the calling employee object
	 * @return: String
	 */
	public String getEmployeeName();
	/**
	 * sets the employee name for the calling employee object
	 * @param employeeName: String
	 */
	public void setEmployeeName(String employeeName);
	/**
	 * return the annual salary (in LPA) of the calling employee object
	 * @return
	 */
	public double getSalaryinLPA();
	/**
	 * sets the salary of employee for the calling employee object
	 * @param salaryinLPA: double
	 */
	public void setSalaryinLPA(double salaryinLPA);
	/**
	 * return the joining date of the calling employee object
	 * @return: LocalDate
	 */
	public LocalDate getDateOfJoining();
	/**
	 * sets the joining date of employee for the calling employee object
	 * @param dateOfJoining: LocalDate
	 */
	public void setDateOfJoining(LocalDate dateOfJoining);
}
