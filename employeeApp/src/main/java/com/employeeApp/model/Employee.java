package com.employeeApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private int empid;
	
	@Column(name = "EmployeeName")
	private String name;
	
	@Column(name = "EmployeeAge")
	private int age;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(int empid, String name, int age) {
		super();
		this.empid = empid;
		this.name = name;
		this.age = age;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", age=" + age + "]";
	}

	
}
