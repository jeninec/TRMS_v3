package dev.clay.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.clay.models.Employee;
import dev.clay.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController {

	EmployeeService es;
	Gson gson = new Gson();
	
	public EmployeeController(EmployeeService es) {
		this.es = es;
	}
	
	public Handler getAllEmployees = (context) -> {

		String name = context.queryParam("name","");
		
		if(name=="") {
			List<Employee> employees = es.getAllEmployees();
			if(employees != null) {
				context.result(gson.toJson(employees));
			} else {
				context.result("[ ]");
			}
				
		} else {
			getEmployeeByUsername(context);
		}
	};
	
	public Handler getEmployeeById = (context) -> {
		
		String input = context.pathParam("id");
		int id;
		
		try {
			id = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			id = -1;
		}
		Employee em = es.getEmployee(id);
		
		populate(context, em);
	};
	
	private void getEmployeeByUsername(Context context) {
		String username = context.queryParam("username");
		
		Employee em = es.getEmployee(username);
		
		populate(context, em);
	}
	
	
	
	public void populate(Context context, Employee em) {
		
		if(em != null) {
			context.result(gson.toJson(em));
		} else {
			context.result("{ }");
		}
	}
}
