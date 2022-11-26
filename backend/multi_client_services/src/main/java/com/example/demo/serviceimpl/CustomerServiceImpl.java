package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.exceptions.CustomerAlreadyExistsException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customerdao;
	@Autowired
	CustomerEntity customerentity;

	@Override
	public MappingJacksonValue getCustomers() {
		List<CustomerEntity> cust = customerdao.getCustomers();
		MappingJacksonValue mappingJacksonValue = customerentity
				.filterCustomerEntity(cust.toArray(new CustomerEntity[0]));
		return mappingJacksonValue;
	}

	@Override
	public MappingJacksonValue getCustomer(int cid) throws CustomerNotFoundException {
		CustomerEntity cust = customerdao.getCustomer(cid);
		MappingJacksonValue mappingJacksonValue = customerentity.filterCustomerEntity(cust);
		if (cust == null) {
			throw new CustomerNotFoundException(cid);
		} else {
			return mappingJacksonValue;
		}
	}

	@Override
	public MappingJacksonValue addCustomer(CustomerEntity customer) throws CustomerAlreadyExistsException {
		if (customerdao.getCustomerByEmail(customer.getCustomerEmail()) != null) {
			throw new CustomerAlreadyExistsException();
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		customer.setCustomerPassword(passwordEncoder.encode(customer.getCustomerPassword()));
		CustomerEntity cust = customerdao.addCustomer(customer);
		MappingJacksonValue mappingJacksonValue = customerentity.filterCustomerEntity(cust);
		return mappingJacksonValue;
	}

	@Override
	public MappingJacksonValue updateCustomer(CustomerEntity customer) {
		CustomerEntity cust = customerdao.addCustomer(customer);
		MappingJacksonValue mappingJacksonValue = customerentity.filterCustomerEntity(cust);
		return mappingJacksonValue;
	}

	@Override
	public boolean deleteCustomer(int cid) throws CustomerNotFoundException {
		boolean deleted = customerdao.deleteCustomer(cid);
		if (!deleted) {
			throw new CustomerNotFoundException(cid);
		}
		return deleted;
	}

}
