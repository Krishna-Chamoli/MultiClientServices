package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException pnfe) {
		Map<String, String> response = new HashMap<>();
		response.put("message", pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCustomerNotFoundException(CustomerNotFoundException cnfe) {
		Map<String, String> response = new HashMap<>();

		response.put("message", cnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MerchantNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleMerchantNotFoundException(MerchantNotFoundException mnfe) {
		Map<String, String> response = new HashMap<>();

		response.put("message", mnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MerchantAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> handleMerchantAlreadyExsitsException(
			MerchantAlreadyExistsException maee) {
		Map<String, String> response = new HashMap<>();

		response.put("message", maee.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> handleCustomerAlreadyExsitsException(
			CustomerAlreadyExistsException caee) {
		Map<String, String> response = new HashMap<>();

		response.put("message", caee.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

}
