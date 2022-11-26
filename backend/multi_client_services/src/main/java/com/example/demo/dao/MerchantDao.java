package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.MerchantEntity;

public interface MerchantDao {
	public List<MerchantEntity> getMerchants();

	public MerchantEntity getMerchant(int mid);

	public MerchantEntity addMerchant(MerchantEntity merchant);

	public MerchantEntity updateMerchant(MerchantEntity merchant);

	public boolean deleteMerchant(int cid);

	public MerchantEntity getMerchantByEmail(String email);
}
