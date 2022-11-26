package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ProductEntity;

public interface ProductDao {
	public List<ProductEntity> getProducts();

	public ProductEntity getProduct(int pid);

	public ProductEntity addProduct(ProductEntity product);

	public boolean deleteProduct(int pid);

	public ProductEntity updateProduct(ProductEntity product);
}
