package com.sk.service;

import java.util.List;


import com.sk.entity.Employee;
import com.sk.model.EmployeeNotFoundException;

public interface IEmployeeServiceImpl {

	public String registerEmployee(Employee employee);

	public List<Employee> fetchAllEmployee();

	public String updateEmployeeDetails(Employee employee) throws EmployeeNotFoundException;
	
	public Employee  fetchEmployeeById(Integer EId) throws EmployeeNotFoundException;
	
	public String deleteEmployeeDetails(Integer EId) throws EmployeeNotFoundException;
	
	


}
