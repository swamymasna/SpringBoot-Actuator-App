package com.swamy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/show")
	public Employee showEmployeeObject() {
		Employee employee = new Employee(100, "SWAMY", 56000.00);
		return employee;
	}

	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		Employee employee1 = new Employee(111, "SWAMY", 56000.00);
		Employee employee2 = new Employee(222, "SIMHA", 66000.00);
		Employee employee3 = new Employee(333, "KING", 76000.00);

		return List.of(employee1, employee2, employee3);
	}

	@GetMapping("/name")
	public String getEmployeeName(@RequestParam(value = "name") String name) {
		Employee employee = new Employee(111, name, 56000.00);
		return "welcome : " + name + " => Your Employee Details : " + employee.toString() ;
	}

	@GetMapping("/name/{name}")
	public String getEmpName(@PathVariable(value = "name") String name) {
		Employee employee = new Employee(111, name, 56000.00);
		return "welcome : " + name.toUpperCase() + " => Your Employee Details : " + employee.toString().toUpperCase() ;
	}
}

