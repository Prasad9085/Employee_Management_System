package com.qsp.new_spring_employee_managment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.new_spring_employee_managment.dao.EmployeeDao;
import com.qsp.new_spring_employee_managment.dto.Employee;
import com.qsp.new_spring_employee_managment.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/find")
	public Employee getEmployee(@RequestParam int id) {
		return service.getEmployee(id);

	}

	@GetMapping("/findAll")
	public List<Employee> getAll() {
		return service.getAll();

	}

	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);

	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam int id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);

	}

	@PatchMapping("/updatephone")
	public Employee updatePhone(@RequestParam int id, @RequestParam long phone) {
		return service.updatePhone(id, phone);

	}

	@PatchMapping("/updateemail/{id}/{email}")
	public Employee updateEmail(@PathVariable int id, @PathVariable String email) {
		return service.updateEmail(id, email);

	}

	@PatchMapping("/updateSalary")
	public Employee updateSalary(@RequestParam int id, @RequestParam double salary) {
		return service.updateSalary(id, salary);

	}

	@PatchMapping("/updateName")
	public Employee updateName(@RequestParam int id, @RequestParam String name) {
		return service.updateName(id, name);

	}

	@PatchMapping("/updateAddress")
	public Employee updateAddress(@RequestParam int id, @RequestParam String address) {
		 return service.updateAddress(id,address);
	}

	@GetMapping("/findByPhone")
	public Employee getByPhone(@RequestParam long phone) {
		return service.getByPhone(phone);

	}

	@GetMapping("/findByEmail")
	public Employee findByEmail(@RequestParam String email) {
		return service.findByEmail(email);

	}

	@GetMapping("/findByName")
	public List<Employee> findByName(@RequestParam String name) {
		return service.findByName(name);
	}

	@GetMapping("/findBySalary")
	public List<Employee> findBySalary(@RequestParam double salary) {
		return service.findBySalary(salary);

	}
	@GetMapping("/findByAddress")
	public List<Employee> findByAddress(@RequestParam String address) {
		return service.findByAddress(address);
		
	}
	@GetMapping("/findByGrade")
	public List<Employee> findByGrade(@RequestParam char grade) {
		return service.findByGrade(grade);
		
	}

	@GetMapping("/salaryLessThan")
	public List<Employee> getEmployeeBySalaryLessThan(@RequestParam double salary) {
		return service.getEmployeeBySalaryLessThan(salary);

	}

	@GetMapping("/salaryGreaterThan")
	public List<Employee> getEmployeeBySalaryGreaterThan(@RequestParam double salary) {
		return service.getEmployeeBySalaryGreaterThan(salary);

	}

	@GetMapping("/employeeSalaryBetween")
	public List<Employee> employeeSalaryBetween(@RequestParam double salary1, @RequestParam double salary2) {
		return service.employeeSalaryBetween(salary1, salary2);

	}
	
	

}
