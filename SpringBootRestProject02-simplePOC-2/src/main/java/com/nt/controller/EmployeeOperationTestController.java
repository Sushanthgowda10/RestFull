package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeOperationTestController {

	@GetMapping("/report")
	public ResponseEntity<String> getAllEmoployees() {
		System.out.println("EmployeeOperationTestController.getAllEmoployees()");

		return new ResponseEntity<String>("GEt-Employee registration", HttpStatus.OK);

	}

	@PostMapping("/update")
	public ResponseEntity<String>updateEmployees() {
		System.out.println("EmployeeOperationTestController.updateEmployees()");
		return new ResponseEntity<String>("POST-Employee updated",HttpStatus.CREATED);
	}

	@PutMapping("/rigister")
	public ResponseEntity<String> rigisterEmoployees() {
		System.out.println("EmployeeOperationTestController.rigisterEmoployees()");
		return new ResponseEntity<String>("PUT-Employee registration", HttpStatus.CREATED);
	}

	@PatchMapping("/emailupdate")
	public ResponseEntity<String> updateEmailEmoployees() {
		System.out.println("EmployeeOperationTestController.updateEmailEmoployees()");
		return new ResponseEntity<String>("PATCH-Employee email is updated", HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmoployees() {
		System.out.println("EmployeeOperationTestController.deleteEmoployees()");
		return new ResponseEntity<String>("DELETE-Employee deleted", HttpStatus.OK);
	}
}