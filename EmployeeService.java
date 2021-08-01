package dev.clay.services;

import java.util.List;

import dev.clay.models.Employee;

public interface EmployeeService {

	public Employee getEmployee(int id);
	
	public Employee getEmployee(String username);
	
	public List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee e);
	
	public Employee updateEmployee(Employee change);
	
	public Employee deleteEmployee(int id);
	
}
