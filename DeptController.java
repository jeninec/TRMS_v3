package dev.clay.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.clay.models.Department;
import dev.clay.services.DeptService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeptController {

	DeptService ds;
	Gson gson = new Gson();
	
	public DeptController(DeptService ds) {
		this.ds = ds;
	}
	
	public Handler getAllDepartments = (context) -> {

		String name = context.queryParam("name","");
		
		if(name=="") {
			List<Department> depts = ds.getAllDepartments();
			if(depts != null) {
				context.result(gson.toJson(depts));
			} else {
				context.result("[ ]");
			}
				
		} else {
			getDepartmentByName(context);
		}
		
	};
	
	public Handler getDepartmentById = (context) -> {
		
		String input = context.pathParam("id");
		int id;
		
		try {
			id = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			id = -1;
		}
		Department d = ds.getDepartment(id);
		
		populate(context,d);
	};
	
	public Handler addDepartment = (context) -> {

		Department d = gson.fromJson(context.body(), Department.class);

		d = ds.addDepartment(d);

		populate(context, d);
	};
	
	public Handler updateDepartment = (context) -> {
		
		Department d = gson.fromJson(context.body(), Department.class);
		d.setId(Integer.parseInt(context.pathParam("id")));
		
		d = ds.updateDepartment(d);
		
		populate(context, d);
	};
	
	public Handler deleteDepartment = (context) -> {
		int id = Integer.parseInt(context.pathParam("id"));
		
		Department d = ds.deleteDepartment(id);
		
		populate(context, d);
	};

	private void getDepartmentByName(Context context) {
		String name = context.queryParam("name");
		
		Department d = ds.getDepartment(name);
		
		populate(context, d);
	}

	// Helper Method to populate the result
	public void populate(Context context, Department d) {
		
		if(d != null) {
			context.result(gson.toJson(d));
		} else {
			context.result("{ }");
		}
	}
}
