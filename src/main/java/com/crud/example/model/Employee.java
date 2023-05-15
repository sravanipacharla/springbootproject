package com.crud.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false)
	@NotBlank(message = "firstname shoudn't be null")
	private String firstname;

	@Column(name = "last_name")
	@NotBlank(message = "lastname shoudn't be null")
	private String lastname;

	@Column(name = "email")
	@NotEmpty
	@Email(message = "invalid email address")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private EmployeeDetails employeeDetails;
 
}
