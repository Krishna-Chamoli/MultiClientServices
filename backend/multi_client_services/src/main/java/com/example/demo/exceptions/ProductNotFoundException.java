package com.example.demo.exceptions;

public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1864322017328176486L;

	public ProductNotFoundException(int pid) {
		super(String.format("Product with Id %d not found", pid));
	}
}
