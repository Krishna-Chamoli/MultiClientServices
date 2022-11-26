package com.example.demo.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Entity
@Component
@JsonFilter("customerFilter")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull
	private String customerName;
	@NotNull
	private String customerMobileNumber;
	@ElementCollection
	private List<ProductEntity> orderHistory;
	@NotNull
	private String customerEmail;
	@NotNull
	private String customerPassword;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public List<ProductEntity> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<ProductEntity> orderHistory) {
		this.orderHistory = orderHistory;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public MappingJacksonValue filterCustomerEntity(CustomerEntity... customer) {
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
				.serializeAllExcept("customerPassword");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("customerFilter",
				simpleBeanPropertyFilter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(customer);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNumber="
				+ customerMobileNumber + ", orderHistory=" + orderHistory + ", customerEmail=" + customerEmail
				+ ", customerPassword=" + customerPassword + "]";
	}

}
