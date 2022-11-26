package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.CustomerEntity;

public interface CustomerDao {

	public List<CustomerEntity> getCustomers();

	public CustomerEntity getCustomer(int cid);

	public CustomerEntity addCustomer(CustomerEntity customer);

	public CustomerEntity updateCustomer(CustomerEntity customer);

	public boolean deleteCustomer(int cid);

	public CustomerEntity getCustomerByEmail(String email);
}
