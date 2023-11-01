package com.qsp.new_spring_employee_managment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.new_spring_employee_managment.dto.Employee;
import com.qsp.new_spring_employee_managment.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);

	}

	public Employee getEmployee(int id) {
		// return repo.findById(id).get();
		// To avoid NoSuchElementException

		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public List<Employee> getAll() {

		return repo.findAll();
	}

	public Employee deleteEmployee(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		repo.deleteById(id);
		return optional.get();
//		
//		Optional<Employee> optional = repo.findById(id);
//		if (optional.isEmpty()) {
//			return null;
//			
//		}
//		Employee employee = optional.get();
//		repo.delete(employee);
//		return employee;
	}

	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			employee.setId(id);
			return repo.save(employee);
		}
		return null;
	}

	public Employee updatePhone(int id, long phone) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;

		}
		Employee employee = optional.get();
		employee.setPhone(phone);
		return repo.save(employee);
	}

	public Employee updateEmail(int id, String email) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;

		}
		Employee employee = optional.get();
		employee.setEmail(email);
		return repo.save(employee);

	}

	public Employee updateSalary(int id, double salary) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setSalary(salary);
			return repo.save(employee);

		}
		return null;
	}

	public Employee updateName(int id, String name) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;

		}
		Employee employee = optional.get();
		employee.setName(name);
		return repo.save(employee);
	}

	public Employee getByPhone(long phone) {
		return repo.findEmployeeByPhone(phone);
	}

	public Employee findByEmail(String email) {
		return repo.employeeByEmail(email);
	}

	public List<Employee> findByName(String name) {
		return repo.findEmployeeByName(name);
	}

	public List<Employee> findBySalary(double salary) {
		return repo.findEmployeesBySalary(salary);
	}

	public List<Employee> getEmployeeBySalaryLessThan(double salary) {
		return repo.findEmployeeBySalaryLessThan(salary);
	}

	public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}

	public List<Employee> employeeSalaryBetween(double salary1, double salary2) {
		return repo.getEmployeeSalaryBetween(salary1, salary2);
	}

	public Employee updateAddress(int id, String address) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setAddress(address);
			return repo.save(employee);

		}
		return null;
	}

	public List<Employee> findByAddress(String address) {
		return repo.findEmployeeByAddress(address);
	}

	public List<Employee> findByGrade(char  grade) {
		return repo.findEmployeeByGrade(grade);
	}

}
