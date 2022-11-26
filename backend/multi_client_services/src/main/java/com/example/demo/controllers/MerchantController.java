package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MerchantEntity;
import com.example.demo.exceptions.MerchantAlreadyExistsException;
import com.example.demo.exceptions.MerchantNotFoundException;
import com.example.demo.service.MerchantService;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

	@Autowired
	MerchantService merchantservice;

	@GetMapping("/")
	public ResponseEntity<MappingJacksonValue> getMerchants() {
		MappingJacksonValue merchantList = merchantservice.getMerchants();
		return new ResponseEntity<>(merchantList, HttpStatus.OK);
	}

	@GetMapping("/merchant")
	public ResponseEntity<MappingJacksonValue> getMerchant(@RequestParam int mid) throws MerchantNotFoundException {
		MappingJacksonValue merchant = merchantservice.getMerchant(mid);
		return new ResponseEntity<>(merchant, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<MappingJacksonValue> addMerchant(@Valid @RequestBody MerchantEntity merchant)
			throws MerchantNotFoundException, MerchantAlreadyExistsException {
		MappingJacksonValue merch = merchantservice.addMerchant(merchant);
		return new ResponseEntity<>(merch, HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<MappingJacksonValue> updateMerchant(@Valid @RequestBody MerchantEntity merchant) {
		MappingJacksonValue merch = merchantservice.updateMerchant(merchant);
		return new ResponseEntity<>(merch, HttpStatus.CREATED);
	}

	@DeleteMapping("/")
	public ResponseEntity<Map<String, String>> deleteMerchant(@RequestParam int mid) throws MerchantNotFoundException {
		boolean deleted = merchantservice.deleteMerchant(mid);
		Map<String, String> response = new HashMap<>();
		if (deleted) {
			response.put("deleted", "yes");
		} else {
			response.put("deleted", "no");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
