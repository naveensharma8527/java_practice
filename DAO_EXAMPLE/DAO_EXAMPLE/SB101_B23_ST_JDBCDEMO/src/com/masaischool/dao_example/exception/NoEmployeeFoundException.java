package com.masaischool.dao_example.exception;

public class NoEmployeeFoundException extends Exception {

	public NoEmployeeFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "No Employee Found " + getMessage();
	}
	
	
}
