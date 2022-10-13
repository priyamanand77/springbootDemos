package com.employeeApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.employeeApp.model.Employee;
import com.employeeApp.service.EmployeeSerice;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeSerice emps;
	
	
	@GetMapping("/")
	public String getAllEmployee(Model  m)
	{
		m.addAttribute("listOfEmp", emps.getAllEmp());
		return "home";
	}
	
	@GetMapping("/addEmp")
	public String addEmpField(Model m)
	{
		Employee e = new Employee();
		m.addAttribute("emp", e);
		return "/addEmp";
	}
	
	
	@PostMapping("/test")
	public String addEmployee(@ModelAttribute Employee e)
	{	
		
		emps.addEmp(e);
		return "redirect:/";
	}
	
	
//	@GetMapping("/getEmployee/{id}")
//	public String getEmployeeDet(@PathVariable(value = "id") int id)
//	{
//		return "/getEmployeeDetails";
//	}
		
	@PostMapping("/showOneEmploye")
	public ModelAndView showOneEmployee(@ModelAttribute Employee e)
	{
		
		Optional<Employee> tempEmp= emps.getEmployee(e.getEmpid());
		Employee newEmp=tempEmp.get();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/showOneEmp");
		mv.addObject("emp", newEmp);
		return mv;
	}

	
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable(value="id") int id)
	{
		emps.deleteEmp(id);
		return "redirect:/";
		
	}

}
