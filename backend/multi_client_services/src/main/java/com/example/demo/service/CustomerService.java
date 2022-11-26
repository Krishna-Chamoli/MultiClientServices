package com.example.demo.service;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.exceptions.CustomerAlreadyExistsException;
import com.example.demo.exceptions.CustomerNotFoundException;

public interface CustomerService {

	public MappingJacksonValue getCustomers();

	public MappingJacksonValue getCustomer(int cid) throws CustomerNotFoundException;

	public MappingJacksonValue addCustomer(CustomerEntity customer) throws CustomerAlreadyExistsException;

	public MappingJacksonValue updateCustomer(CustomerEntity customer);

	public boolean deleteCustomer(int cid) throws CustomerNotFoundException;
}
