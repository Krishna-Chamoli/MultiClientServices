package com.example.demo.exceptions;

public class MerchantNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1510615917180674240L;

	public MerchantNotFoundException(int mid) {
		super(String.format("Merchant with id %d not found", mid));
	}
}
