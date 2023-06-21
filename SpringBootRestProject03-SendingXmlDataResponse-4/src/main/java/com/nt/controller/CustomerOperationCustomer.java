package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
public class CustomerOperationCustomer {
	@GetMapping("/report")
	public ResponseEntity<Customer>showData() {
		Customer cust = new Customer (1001, "sush","bengalore",123456.77f);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}

}
