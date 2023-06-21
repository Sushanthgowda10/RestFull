package com.nt.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;
@RestController
public class CustomerControlOperation {
	@PostMapping("/report")
	public ResponseEntity<String> showData(@RequestBody Customer cust) {
		
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<String>(cust.toString(), status);
	}

}
