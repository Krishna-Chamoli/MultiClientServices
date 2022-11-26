package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MerchantDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.MerchantEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptions.MerchantNotFoundException;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productdao;
	@Autowired
	MerchantDao merchantdao;

	@Override
	public List<ProductEntity> getProducts() {
		List<ProductEntity> productList = productdao.getProducts();
		return productList;
	}

	@Override
	public ProductEntity getProduct(int pid) throws ProductNotFoundException {
		ProductEntity product = productdao.getProduct(pid);
		if (product == null) {
			throw new ProductNotFoundException(pid);
		}
		return product;
	}

	@Override
	public ProductEntity addProduct(ProductEntity product, int merchantId) throws MerchantNotFoundException {
		MerchantEntity merch = merchantdao.getMerchant(merchantId);
		if (merch == null) {
			throw new MerchantNotFoundException(merchantId);
		}
		product.setMerchantId(merchantId);
		product.setMerchant(merch);
		ProductEntity p = productdao.addProduct(product);
		return p;
	}

	@Override
	public boolean deleteProduct(int pid) throws ProductNotFoundException {
		boolean deleted = productdao.deleteProduct(pid);
		if (!deleted) {
			throw new ProductNotFoundException(pid);
		}
		return deleted;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		MerchantEntity merchant = merchantdao.getMerchant(product.getMerchantId());
		product.setMerchant(merchant);
		ProductEntity p = productdao.updateProduct(product);
		return p;
	}

}
