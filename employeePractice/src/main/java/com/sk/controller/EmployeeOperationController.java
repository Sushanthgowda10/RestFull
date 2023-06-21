package com.sk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.entity.Employee;
import com.sk.service.IEmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationController {

	
	@Autowired
	private IEmployeeServiceImpl employeeService;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollEmployere(@RequestBody Employee employee) {
	try {
		String resultMsg = employeeService.registerEmployee(employee);
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<String>("Problem in Employee Enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?>displayEmployee() {
		try {
			List<Employee> list = employeeService.fetchAllEmployee();
			System.out.println(list.size());
			return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		} catch (Exception e) {
		return new ResponseEntity<String>("Problem in fetching Tourist try again..",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		try {
			String msg = employeeService.updateEmployeeDetails(employee);
			responseEntity = new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch ( Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayEmployeeById(@PathVariable("id") Integer id) {
		try {
			Employee employee = employeeService.fetchEmployeeById(id);
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("delete/{id}")
	
	

//	@DeleteMapping("delete/{id}")
//	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id) {
//		try {
//			String msg = touristService.deleteTouristDetails(id);
//			return new ResponseEntity<String>(msg, HttpStatus.OK);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//
//		}
//	
//	
//	
//	
	
}
	

	
	


	
	


