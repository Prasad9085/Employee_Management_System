package com.qsp.new_spring_employee_managment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.new_spring_employee_managment.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	Employee findEmployeeByPhone(long phone);

	// Employee getEmployeeByEmail(String email);
	@Query("SELECT e FROM Employee e WHERE e.email = ?1")
	Employee employeeByEmail(String email);

	List<Employee> findEmployeeByName(String name);

	List<Employee> findEmployeesBySalary(double salary);

	List<Employee> findEmployeeBySalaryLessThan(double salary);

	List<Employee> findEmployeeBySalaryGreaterThan(double salary);

	// @Query("select e from Employee e where e.salary >= ?1 and e.salary <= ?2")
	@Query("select e from Employee e where e.salary between ?1 And ?2")
	List<Employee> getEmployeeSalaryBetween(double salary1, double salary2);

	List<Employee> findEmployeeByAddress(String address);
	
	List<Employee> findEmployeeByGrade(char grade);

}
