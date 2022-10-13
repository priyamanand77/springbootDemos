package com.employeeApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeApp.dao.EmployeeRepo;
import com.employeeApp.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeSerice {

	@Autowired
	EmployeeRepo emp;
	
	
	@Override
	public List<Employee> getAllEmp() {
		return  emp.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
		
		Optional<Employee> em=	emp.findById(id);
		if(em.isPresent())
		{
			return em;
		}else
		{
			throw new RuntimeException("Employee of "+id+" does not exist");
		}
	}

	@Override
	public String deleteAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmp(int id) {
		
		emp.deleteById(id);
		
		return "deleted successful";
	}

	@Override
	public Employee updateEmp(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addEmp(Employee e) {
		emp.save(e);
		return "Employee Added into database";
	}

}
