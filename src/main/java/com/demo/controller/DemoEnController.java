package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.entity.Skill;
import com.demo.repository.EmployeeRepo;
import com.demo.service.EmployeeImpl;

@RestController
@EnableTransactionManagement
public class DemoEnController {
	
	@Autowired
	EmployeeImpl employeeImpl;
	
	@GetMapping("/employee/{id}")
	public Employee employeeDetails(@PathVariable int id) {
		return employeeImpl.findById(id);
	}

	@PostMapping("/getList")
	public List<Employee> addEmployee() {
		return employeeImpl.addEmployee();
	}

	@PostMapping("/cascade/{empid}")
	public Employee casExample(@RequestBody List<Skill> skill, @PathVariable int empid) {
		return employeeImpl.casExample(skill,empid);
		
	}
	@PostMapping("/cascadePersist")
	public Employee casPersistExample(@RequestBody Employee emp) {
		return employeeImpl.casPersistExample(emp);
		
	}
	@PostMapping("/cascadeRemove/{id}")
	public Employee cascadeRemove(@PathVariable int id) {
		return employeeImpl.cascadeRemove(id);
		
	}
	
}
