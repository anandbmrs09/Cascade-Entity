package com.demo.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.entity.Skill;
import com.demo.repository.EmployeeRepo;

@Service
@Transactional
public class EmployeeImpl  {
	
	
	@Autowired
	private EmployeeRepo emp;
	
    
	public Employee findById(int id) {
	
		return emp.findById(id).orElse(null);
	}

	public List<Employee> addEmployee() {
		
		Employee e = new Employee(1,"Anand", "Panvel", 25000,"Indian");
		Employee e1 = new Employee(2,"Mahesh", "Mumbra", 25000,"Indian");
		emp.saveAll(Arrays.asList(e,e1));
		return Arrays.asList(e,e1);
	}

	public Employee casExample(List<Skill> skill, int empid) {

		List<Skill> skillList = new ArrayList<Skill>();
		Employee e = emp.findById(empid).orElse(null);
		for (Skill str : skill) {
			Skill k = new Skill();
			k.setId(str.getId());
			k.setName(str.getName());
			skillList.add(k);
		}
		e.setSkill(skillList);
		emp.save(e);
		return e;
	}

	public Employee casPersistExample(Employee emp2) {
		return  emp.save(emp2);
	}

	public Employee cascadeRemove(int id) {
		Employee e = emp.findById(id).orElse(null);
		emp.delete(e);
		return e;
	}
}
