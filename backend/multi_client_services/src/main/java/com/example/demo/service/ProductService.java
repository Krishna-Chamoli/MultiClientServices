package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptions.MerchantNotFoundException;
import com.example.demo.exceptions.ProductNotFoundException;

public interface ProductService {
	public List<ProductEntity> getProducts();

	public ProductEntity getProduct(int pid) throws ProductNotFoundException;

	public ProductEntity addProduct(ProductEntity product, int merchantId) throws MerchantNotFoundException;

	public boolean deleteProduct(int pid) throws ProductNotFoundException;

	public ProductEntity updateProduct(ProductEntity product);
}
