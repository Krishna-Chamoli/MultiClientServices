package com.example.demo.exceptions;

public class MerchantAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9027415395920822548L;

	public MerchantAlreadyExistsException() {
		super(String.format("Merchant email already exists"));
	}
}
