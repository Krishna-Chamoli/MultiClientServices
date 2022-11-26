package com.example.demo.exceptions;

public class CustomerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5308773561238112188L;

	public CustomerNotFoundException(int cid) {
		super(String.format("Customer with id %d not found", cid));
	}
}
