package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MerchantDao;
import com.example.demo.entity.MerchantEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptions.MerchantAlreadyExistsException;
import com.example.demo.exceptions.MerchantNotFoundException;
import com.example.demo.service.MerchantService;
import com.example.demo.service.ProductService;

@Service
public class MerchantServiceImpl implements MerchantService {
	@Autowired
	MerchantDao merchantdao;
	@Autowired
	MerchantEntity merchantentity;
	@Autowired
	ProductService productservice;

	@Override
	public MappingJacksonValue getMerchants() {
		List<MerchantEntity> merchantList = merchantdao.getMerchants();
		MappingJacksonValue mappingJacksonValue = merchantentity
				.filterMerchantEntity(merchantList.toArray(new MerchantEntity[0]));

		return mappingJacksonValue;
	}

	@Override
	public MappingJacksonValue getMerchant(int mid) throws MerchantNotFoundException {
		MerchantEntity merchant = merchantdao.getMerchant(mid);
		if (merchant == null) {
			throw new MerchantNotFoundException(mid);
		}
		MappingJacksonValue mappingJacksonValue = merchantentity.filterMerchantEntity(merchant);
		return mappingJacksonValue;
	}

	@Override
	public MappingJacksonValue addMerchant(MerchantEntity merchant)
			throws MerchantNotFoundException, MerchantAlreadyExistsException {

		if (merchantdao.getMerchantByEmail(merchant.getMerchantEmail()) != null) {
			throw new MerchantAlreadyExistsException();
		}

		List<ProductEntity> products = merchant.getMerchantProducts();

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		merchant.setMerchantPassword(passwordEncoder.encode(merchant.getMerchantPassword()));

		MerchantEntity merch = merchantdao.addMerchant(merchant);

		for (ProductEntity prod : products) {
			prod.setMerchant(merch);
			productservice.addProduct(prod, merch.getMerchantId());
		}

		MappingJacksonValue mappingJacksonValue = merchantentity.filterMerchantEntity(merch);
		return mappingJacksonValue;
	}

	@Override
	public MappingJacksonValue updateMerchant(MerchantEntity merchant) {
		List<ProductEntity> productList = merchant.getMerchantProducts();
		MerchantEntity merch = merchantdao.updateMerchant(merchant);
		for (ProductEntity prod : productList) {
			prod.setMerchant(merch);
			productservice.updateProduct(prod);
		}
		MappingJacksonValue mappingJacksonValue = merchantentity.filterMerchantEntity(merch);
		return mappingJacksonValue;
	}

	@Override
	public boolean deleteMerchant(int mid) throws MerchantNotFoundException {
		boolean deleted = merchantdao.deleteMerchant(mid);
		if (!deleted) {
			throw new MerchantNotFoundException(mid);
		}
		return true;
	}

}
