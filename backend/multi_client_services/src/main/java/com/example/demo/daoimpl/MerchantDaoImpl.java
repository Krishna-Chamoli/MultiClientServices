package com.example.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.MerchantDao;
import com.example.demo.entity.MerchantEntity;
import com.example.demo.repository.MerchantRepository;

@Repository
public class MerchantDaoImpl implements MerchantDao {
	@Autowired
	MerchantRepository merchantrepo;

	@Override
	public List<MerchantEntity> getMerchants() {
		List<MerchantEntity> merchantList = merchantrepo.findAll();
		return merchantList;
	}

	@Override
	public MerchantEntity getMerchant(int mid) {
		MerchantEntity merchant = merchantrepo.findById(mid).orElse(null);
		return merchant;
	}

	@Override
	public MerchantEntity addMerchant(MerchantEntity merchant) {
		MerchantEntity merch = merchantrepo.save(merchant);
		return merch;
	}

	@Override
	public MerchantEntity updateMerchant(MerchantEntity merchant) {
		MerchantEntity merch = merchantrepo.save(merchant);
		return merch;
	}

	@Override
	public boolean deleteMerchant(int cid) {
		MerchantEntity merch = merchantrepo.findById(cid).orElse(null);
		if (merch != null) {
			merchantrepo.delete(merch);
			return true;
		}
		return false;
	}

	@Override
	public MerchantEntity getMerchantByEmail(String email) {
		MerchantEntity merchant = merchantrepo.findByMerchantEmail(email);
		return merchant;
	}

}
