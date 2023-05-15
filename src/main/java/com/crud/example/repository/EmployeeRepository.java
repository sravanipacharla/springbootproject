package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.example.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>  {

	


}
