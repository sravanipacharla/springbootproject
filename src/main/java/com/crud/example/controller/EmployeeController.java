package com.crud.example.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.crud.example.model.Employee;
import com.crud.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;

//	public EmployeeController(EmployeeService employeeservice) {
//		super();
//		this.employeeservice = employeeservice;
//	}
	// build create employee REST API
	
	@PostMapping("/saveemployee")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee)  {
		return new ResponseEntity<>(employeeservice.saveEmployee(employee), HttpStatus.OK);
	}
	// build get all employees REST API

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeservice.getEmployees();
	}
	// build get employee by id REAT API

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId) {
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(employeeId), HttpStatus.OK);
	}

	// build update employee REST API
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee, id), HttpStatus.OK);

	}

	// build delete employee REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		// delete employee from DB

		employeeservice.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully.", HttpStatus.OK);
	}

}
