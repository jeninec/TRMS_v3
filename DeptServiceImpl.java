package dev.clay.services;

import java.util.List;

import dev.clay.models.Department;
import dev.clay.repositories.DeptRepo;

public class DeptServiceImpl implements DeptService {

	DeptRepo dr;
	
	
	public DeptServiceImpl(DeptRepo dr) {
		this.dr = dr;
	}

	public Department getDepartment(int id) {
		return dr.getDepartment(id);
	}

	public Department getDepartment(String name) {
		return dr.getDepartment(name);
	}

	public List<Department> getAllDepartments() {
		return dr.getAllDepartments();
	}

	public Department addDepartment(Department d) {
		return dr.addDepartment(d);
	}

	public Department updateDepartment(Department change) {
		return dr.updateDepartment(change);
	}

	public Department deleteDepartment(int id) {
		return dr.deleteDepartment(id);
	}

}
