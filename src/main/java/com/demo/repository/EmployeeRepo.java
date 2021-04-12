package com.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
