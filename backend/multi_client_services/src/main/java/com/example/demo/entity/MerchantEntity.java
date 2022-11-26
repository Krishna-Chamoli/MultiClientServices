package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import javax.validation.constraints.NotNull;

@Entity
@Component
@JsonFilter("merchantFilter")
public class MerchantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merchantId;
	@NotNull
	private String merchantName;
	@NotNull
	private String merchantMobileNumber;
	@ElementCollection
	@OneToMany(mappedBy = "merchant", cascade = CascadeType.REMOVE)
	private List<ProductEntity> merchantProducts;
	@NotNull
	@Column(unique = true)
	private String merchantEmail;
	@NotNull
	private String merchantPassword;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantMobileNumber() {
		return merchantMobileNumber;
	}

	public void setMerchantMobileNumber(String merchantMobileNumber) {
		this.merchantMobileNumber = merchantMobileNumber;
	}

	public List<ProductEntity> getMerchantProducts() {
		return merchantProducts;
	}

	public void setMerchantProducts(List<ProductEntity> merchantProducts) {
		this.merchantProducts = merchantProducts;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public MappingJacksonValue filterMerchantEntity(MerchantEntity... merchant) {
		SimpleBeanPropertyFilter simplePropertyBeanFilter = SimpleBeanPropertyFilter
				.serializeAllExcept("merchantPassword");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("merchantFilter",
				simplePropertyBeanFilter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(merchant);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

	@Override
	public String toString() {
		return "MerchantEntity [merchantId=" + merchantId + ", merchantName=" + merchantName + ", merchantMobileNumber="
				+ merchantMobileNumber + ", merchantProducts=" + merchantProducts + ", merchantEmail=" + merchantEmail
				+ ", merchantPassword=" + merchantPassword + "]";
	}

}
