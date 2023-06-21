package com.sk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.entity.Employee;
import com.sk.model.EmployeeNotFoundException;
import com.sk.repository.Repository;

@Service
public class EmployeeServicerImpl implements IEmployeeServiceImpl {

	@Autowired
	private Repository EmpRepo;

	@Override
	public String registerEmployee(Employee employee) {

	Integer EId = EmpRepo.save(employee).getEId();
	return "Employee is registered having the Id value::"+EId;
	}

@Override
	public List <Employee>fetchAllEmployee() {
		
	List<Employee> list = EmpRepo.findAll();
	list.sort((t1,t2)-> t1.getEId().compareTo(t2.getEId()));
	return list;
	}

@Override
   public String updateEmployeeDetails(Employee employee) throws EmployeeNotFoundException {
	   Optional<Employee> optional = EmpRepo.findById(employee.getEId());
	   if(optional.isPresent() ) {
		   EmpRepo.save(employee) ;
		   return employee.getEId()+ "Employee is updated";
	   }else
		   throw new EmployeeNotFoundException(employee.getEId() +"Employee not found");
   }


@Override
 public Employee  fetchEmployeeById(Integer EId) throws EmployeeNotFoundException {
	return EmpRepo.findById(EId).orElseThrow(() -> new EmployeeNotFoundException(EId + "Employee not found"));
}		


@Override
public String deleteEmployeeDetails(Integer EId) throws EmployeeNotFoundException {
	 Optional<Employee> optional = EmpRepo.findById(EId);
	 if(optional.isPresent()) {
		 EmpRepo.delete(optional.get());
		 return EId +"Employee deleted";
	 } else 
		 throw new EmployeeNotFoundException(EId + "Employee not found");
	

	}
}



	
