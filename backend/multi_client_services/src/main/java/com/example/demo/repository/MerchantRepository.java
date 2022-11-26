package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MerchantEntity;

public interface MerchantRepository extends JpaRepository<MerchantEntity, Integer> {
	public MerchantEntity findByMerchantEmail(String email);
}
