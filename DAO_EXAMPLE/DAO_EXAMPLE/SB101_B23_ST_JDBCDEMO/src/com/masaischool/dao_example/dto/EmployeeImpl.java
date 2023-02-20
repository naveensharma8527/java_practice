package com.masaischool.dao_example.dto;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeImpl implements Employee {
	private String employeeId;
	private String employeeName;
	private double salaryinLPA;
	private LocalDate dateOfJoining;
	
	public EmployeeImpl() {}
	
	public EmployeeImpl(String employeeId, String employeeName, double salaryinLPA, LocalDate dateOfJoining) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salaryinLPA = salaryinLPA;
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalaryinLPA() {
		return salaryinLPA;
	}

	public void setSalaryinLPA(double salaryinLPA) {
		this.salaryinLPA = salaryinLPA;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public int hashCode() {
		return employeeId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeImpl other = (EmployeeImpl) obj;
		return Objects.equals(employeeId, other.employeeId);
	}

	@Override
	public String toString() {
		return "Employee Id: " + employeeId + ", Employee Name: " + employeeName + ", Salary per annum (In LPA): "
				+ salaryinLPA + ", Date Of Joining=" + dateOfJoining + "]";
	}
}
