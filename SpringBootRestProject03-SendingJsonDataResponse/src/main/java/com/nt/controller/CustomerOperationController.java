package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
public class CustomerOperationController {

//@GetMapping("/report") 
//public ResponseEntity<Customer> showDate() {
//	Customer cust= new Customer (1001, "sush","Bangalore",1234.7f);
//	HttpStatus status =HttpStatus.OK;
//	return new ResponseEntity<customer>(cust,status);
//	

	@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001, "sush", "Bangalore", 1234.7f, new String[] { "red", "black", "green" },
				List.of("10th", "10+2", "B-tech"), Set.of(1234567L, 987654L, 234567898765L),
				Map.of("aadhar", 34567L, "pan", 45678L), new Company("softtek", "bengalore", "IT"));

		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}

}
