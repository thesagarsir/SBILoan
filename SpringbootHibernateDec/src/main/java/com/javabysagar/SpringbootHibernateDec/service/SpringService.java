package com.javabysagar.SpringbootHibernateDec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabysagar.SpringbootHibernateDec.dao.SpringDao;
import com.javabysagar.SpringbootHibernateDec.entities.Country;
import com.javabysagar.SpringbootHibernateDec.entities.Employee;

@Service
public class SpringService {
//business logic
	@Autowired
	SpringDao springdao;

	public List<Employee> ListEmployee() {
		List<Employee> listemployee=springdao.ListEmployee();
		return listemployee;
	}

	public Employee getEmployeebyId(int id) {
		Employee emp=springdao.getEmployeebyId(id);
		return emp;
	}

	public Employee getEmployeebyName(String name) {
		
		Employee emp=springdao.getEmployeebyName(name);
		return emp;
	}

	public List<Employee> getEmployeebyStatus(String status) {
		List<Employee> emplist=springdao.getEmployeebyStatus(status);
		return emplist;
	}

	public boolean saveEmployee(Employee emp) {
		boolean result=springdao.saveEmployee(emp);
		return result;
	}

	public boolean saveCountry(Country country) {
		boolean result=springdao.saveCountry(country);
		return result;
	}

	public boolean deletecountrybyname(String cname) {
		boolean result=springdao.deletecountrybyname(cname);
		return result;
	}

	public boolean deleteEmployeebyId(int id) {
		boolean result=springdao.deleteEmployeebyId(id);
		return result;
	}

	public boolean updateCountry(Country country) {
		boolean result=springdao.updateCountry(country);
		return result;
	}

	public boolean updateEmployee(Employee emp) {
		boolean result=springdao.updateEmployee(emp);
		return result;
	}

	public List<Employee> employeeListBeforeToday() {
		List<Employee> listemployee=springdao.employeeListBeforeToday();
		return listemployee;
	}
	
	
}
