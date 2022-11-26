package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.exceptions.CustomerAlreadyExistsException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@GetMapping("/")
	public ResponseEntity<MappingJacksonValue> getCustomers() {
		MappingJacksonValue mappingJacksonValue = customerservice.getCustomers();
		return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
	}

	@GetMapping("/customer")
	public ResponseEntity<MappingJacksonValue> getCustomer(@RequestParam int cid) throws CustomerNotFoundException {
		MappingJacksonValue mappingJacksonValue = customerservice.getCustomer(cid);
		return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<MappingJacksonValue> addCustomer(@Valid @RequestBody CustomerEntity customer)
			throws CustomerAlreadyExistsException {
		MappingJacksonValue mappingJacksonValue = customerservice.addCustomer(customer);
		return new ResponseEntity<>(mappingJacksonValue, HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<MappingJacksonValue> updateCustomer(@RequestBody CustomerEntity customer) {
		MappingJacksonValue mappingJacksonValue = customerservice.updateCustomer(customer);
		return new ResponseEntity<>(mappingJacksonValue, HttpStatus.CREATED);
	}

	@DeleteMapping("/")
	public ResponseEntity<Map<String, String>> deleteCustomer(@RequestParam int cid) throws CustomerNotFoundException {
		Map<String, String> response = new HashMap<>();
		boolean deleted = customerservice.deleteCustomer(cid);
		if (deleted) {
			response.put("deleted", "yes");
		} else {
			response.put("deleted", "no");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
