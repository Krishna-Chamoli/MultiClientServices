package com.example.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository productrepo;

	@Override
	public List<ProductEntity> getProducts() {
		List<ProductEntity> productList = productrepo.findAll();
		return productList;
	}

	@Override
	public ProductEntity getProduct(int pid) {
		ProductEntity product = productrepo.findById(pid).orElse(null);
		return product;
	}

	@Override
	public ProductEntity addProduct(ProductEntity product) {
		ProductEntity p = productrepo.save(product);
		return p;
	}

	@Override
	public boolean deleteProduct(int pid) {
		ProductEntity p = productrepo.findById(pid).orElse(null);
		if (p == null) {
			return false;
		}
		productrepo.delete(p);
		return true;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		ProductEntity p = productrepo.save(product);
		return p;
	}

}
