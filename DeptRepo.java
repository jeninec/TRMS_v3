package dev.clay.repositories;

import java.util.List;

import dev.clay.models.Department;

public interface DeptRepo {

	public Department getDepartment(int id);
	
	public Department getDepartment(String name);
	
	public List<Department> getAllDepartments();
	
	public Department addDepartment(Department d);
	
	public Department updateDepartment(Department change);
	
	public Department deleteDepartment(int id);
	
}
