package com.example.demo.service;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.example.demo.entity.MerchantEntity;
import com.example.demo.exceptions.MerchantAlreadyExistsException;
import com.example.demo.exceptions.MerchantNotFoundException;

public interface MerchantService {

	public MappingJacksonValue getMerchants();

	public MappingJacksonValue getMerchant(int mid) throws MerchantNotFoundException;

	public MappingJacksonValue addMerchant(MerchantEntity merchant)
			throws MerchantNotFoundException, MerchantAlreadyExistsException;

	public MappingJacksonValue updateMerchant(MerchantEntity merchant);

	public boolean deleteMerchant(int mid) throws MerchantNotFoundException;
}
