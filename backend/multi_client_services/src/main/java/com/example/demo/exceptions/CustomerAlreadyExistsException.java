package com.example.demo.exceptions;

public class CustomerAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1363041985990468018L;

	public CustomerAlreadyExistsException() {
		super(String.format("Customer with email already exists"));
	}
}
