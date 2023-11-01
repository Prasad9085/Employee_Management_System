package com.qsp.new_spring_employee_managment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.new_spring_employee_managment.dao.EmployeeDao;
import com.qsp.new_spring_employee_managment.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public Employee saveEmployee(Employee employee) {
		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('C');

		} else if (salary > 20000 && salary <= 35000) {
			employee.setGrade('B');

		} else {
			employee.setGrade('A');
		}
		return dao.saveEmployee(employee);
	}

	public Employee getEmployee(@RequestParam int id) {
		return dao.getEmployee(id);
	}

	public List<Employee> getAll() {
		return dao.getAll();
	}

	public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

	public Employee updateEmployee(int id, Employee employee) {

		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('C');

		} else if (salary > 20000 && salary <= 35000) {
			employee.setGrade('B');

		} else {
			employee.setGrade('A');
		}
		return dao.updateEmployee(id, employee);
	}

	public Employee updatePhone(int id, long phone) {
		return dao.updatePhone(id, phone);
	}

	public Employee updateEmail(int id, String email) {
		return dao.updateEmail(id, email);
	}

	public Employee updateSalary(int id, double salary) {
		Employee employee = dao.getEmployee(id);

		if (salary <= 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('C');

		} else if (salary > 20000 && salary <= 35000) {
			employee.setGrade('B');

		} else {
			employee.setGrade('A');
		}
		return dao.updateSalary(id, salary);
	}

	public Employee updateName(@RequestParam int id, @RequestParam String name) {
		return dao.updateName(id, name);
	}

	public Employee getByPhone(@RequestParam long phone) {
		return dao.getByPhone(phone);
	}

	public Employee findByEmail(@RequestParam String email) {
		return dao.findByEmail(email);

	}

	public List<Employee> findByName(@RequestParam String name) {
		return dao.findByName(name);
	}

	public List<Employee> findBySalary(@RequestParam double salary) {
		return dao.findBySalary(salary);

	}

	public List<Employee> getEmployeeBySalaryLessThan(@RequestParam double salary) {
		return dao.getEmployeeBySalaryLessThan(salary);

	}

	public List<Employee> getEmployeeBySalaryGreaterThan(@RequestParam double salary) {
		return dao.getEmployeeBySalaryGreaterThan(salary);

	}

	public List<Employee> employeeSalaryBetween(@RequestParam double salary1, @RequestParam double salary2) {
		return dao.employeeSalaryBetween(salary1, salary2);

	}

	public Employee updateAddress(int id, String address) {
		return dao.updateAddress(id, address);
	}

	public List<Employee> findByAddress(String address) {
		return dao.findByAddress(address);
	}

	public List<Employee> findByGrade(char grade) {
		return dao.findByGrade(grade);
	}
}
