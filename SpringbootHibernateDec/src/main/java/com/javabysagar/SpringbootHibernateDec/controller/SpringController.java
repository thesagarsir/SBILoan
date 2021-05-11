package com.javabysagar.SpringbootHibernateDec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabysagar.SpringbootHibernateDec.entities.Country;
import com.javabysagar.SpringbootHibernateDec.entities.Employee;
import com.javabysagar.SpringbootHibernateDec.service.SpringService;

@RestController
public class SpringController {

	@Autowired
	SpringService service;
	
	
	@RequestMapping("/getallemployee")
	public List<Employee> ListEmployee()
	{
		List<Employee> listemployee=service.ListEmployee();
		return listemployee;
	}
	
	@RequestMapping("/getemployeebyid/{id}")
	public Employee getEmployeebyId(@PathVariable int id)
	{
		System.out.println(id);
		Employee emp=service.getEmployeebyId(id);
		return emp;
	}
	
	@RequestMapping("/getemployeebyname/{name}")
	public Employee getEmployeebyName(@PathVariable String name)
	{
		System.out.println(name);
		Employee emp=service.getEmployeebyName(name);
		
		return emp;
	}
	
	@RequestMapping("/getemployeebystatus/{status}")
	public List<Employee> getEmployeebyStatus(@PathVariable String status)
	{
		System.out.println(status);
		List<Employee> emplist=service.getEmployeebyStatus(status);
		
		return emplist;
	}
	
	
	@PostMapping("/saveemployee")
	public String saveEmployee(@RequestBody Employee emp)
	{
		System.out.println(emp.getName());
		
		boolean result=service.saveEmployee(emp);
		if(result)
		{
			return "Data Saved Successfuly";
		}
		else
		{
			return "Error";
		}
	
	}
	
	@PostMapping("/savecountry")
	public String saveCountry(@RequestBody Country country)
	{
		System.out.println(country.getCname());
		
		boolean result=service.saveCountry(country);
		if(result)
		{
			return "Country Added successfully";
		}
		else
		{
			return "Error";
		}
		
	}
	
	@DeleteMapping("/deletecountry/{cname}")
	public String deletecountrybyname(@PathVariable String cname)
	{
		System.out.println(cname);
		boolean result=service.deletecountrybyname(cname);
		if(result)
		{
			return "Country"+cname+ "Deleted Successfully!";
		}
		else
		{
			return "Error";
		}
	
	}
	
	@DeleteMapping("/deleteemployeebyid/{id}")
	public String deleteEmployeebyId(@PathVariable int id)
	{
		System.out.println(id);
		boolean result=service.deleteEmployeebyId(id);
		if(result)
		{
			return "Employee"+id+"Deleted Successfully!!";
		}
		else
		{
			return "Error";
		}
	
	}
	
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country country)
	{
		System.out.println(country.getCname());
		boolean result=service.updateCountry(country);
		if(result)
		{
			return "Country "+country.getCid()+" updated Successfully!!";
		}
		else{
			return "Error";
		}
		
	}
	
	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee emp)
	{
		boolean result=service.updateEmployee(emp);
		if(result)
		{
			return "Employee Updated Successfully";
		}
		else
		{
			return "Error";
		}
		
	}
	
	@GetMapping("/employeelistbeforetoday")
	public List<Employee> employeeListBeforeToday()
	{
		List<Employee> listemployee=service.employeeListBeforeToday();
		if(!listemployee.isEmpty())
		{
			return listemployee;
		}
		else
		{
			return null;
		}
		
	}
	
}
