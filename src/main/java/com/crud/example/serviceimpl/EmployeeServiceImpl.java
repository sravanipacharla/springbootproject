package com.crud.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.exception.ResourceNotFoundException;
import com.crud.example.model.Employee;
import com.crud.example.repository.EmployeeRepository;
import com.crud.example.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeerepository;

   
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeerepository.save(employee);
	
	}
	
	@Override 
	public List<Employee> getEmployees() {
		return employeerepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long id) {
//  Optional<Employee> employee = employeerepository.findById(id);
//  if(employee.isPresent()) {
//	return employee.get();
//	}else {
//	throw new ResourceNotFoundExpection("Employee","Id",id);
//		}
		return employeerepository.findById(id).orElseThrow(()->
		      new ResourceNotFoundException("Employee", "Id",id));
	}
    @Override
    public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeerepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee","id",id));
		
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to DB
		employeerepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in a DB or not
		employeerepository.findById(id).orElseThrow(() ->
		         new ResourceNotFoundException("Employee","Id",id));
		employeerepository.deleteById(id);

	}

	

	
}
