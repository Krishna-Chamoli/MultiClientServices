package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptions.MerchantNotFoundException;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService productservice;

	@GetMapping("/")
	public ResponseEntity<List<ProductEntity>> getProducts() {
		List<ProductEntity> productList = productservice.getProducts();

		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@GetMapping("/product")
	public ResponseEntity<ProductEntity> getProduct(@RequestParam int pid) throws ProductNotFoundException {
		ProductEntity product = productservice.getProduct(pid);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ProductEntity> addProduct(@Valid @RequestBody ProductEntity product,
			@RequestParam int merchantId) throws MerchantNotFoundException {
		ProductEntity p = productservice.addProduct(product, merchantId);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	@DeleteMapping("/")
	public ResponseEntity<Map<String, String>> deleteProduct(@RequestParam int pid) throws ProductNotFoundException {
		Map<String, String> response = new HashMap<>();
		boolean deleted = productservice.deleteProduct(pid);
		if (deleted) {
			response.put("deleted", "yes");
		} else {
			response.put("deleted", "no");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product) {
		ProductEntity p = productservice.updateProduct(product);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
}
