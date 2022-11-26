package com.example.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	CustomerRepository customerrepo;

	@Override
	public List<CustomerEntity> getCustomers() {
		List<CustomerEntity> customerList = customerrepo.findAll();
		return customerList;
	}

	@Override
	public CustomerEntity getCustomer(int cid) {
		CustomerEntity cust = customerrepo.findById(cid).orElse(null);
		return cust;
	}

	@Override
	public CustomerEntity addCustomer(CustomerEntity customer) {
		CustomerEntity cust = customerrepo.save(customer);
		return cust;
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity customer) {
		CustomerEntity cust = customerrepo.save(customer);
		return cust;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		CustomerEntity cust = customerrepo.findById(cid).orElse(null);
		if (cust == null) {
			return false;
		}
		customerrepo.delete(cust);
		return true;
	}

	@Override
	public CustomerEntity getCustomerByEmail(String email) {
		CustomerEntity customer = customerrepo.findByCustomerEmail(email);
		return customer;
	}

}
