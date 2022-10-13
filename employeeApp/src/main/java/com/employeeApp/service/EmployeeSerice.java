package com.employeeApp.service;

import java.util.List;
import java.util.Optional;

import com.employeeApp.model.Employee;

public interface EmployeeSerice {

	public List<Employee> getAllEmp();

	public Optional<Employee> getEmployee(int id);

	public String deleteAllEmp();

	public String deleteEmp(int id);

	public Employee updateEmp(int id);

	public String addEmp(Employee e);
}
