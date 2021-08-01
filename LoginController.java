package dev.clay.controllers;

import com.google.gson.Gson;

import dev.clay.models.Employee;
import dev.clay.services.LoginService;
import io.javalin.http.Handler;

public class LoginController {

	LoginService ls;
	Gson gson = new Gson();
	
	public LoginController(LoginService ls) {
		this.ls = ls;
	}
	
	public Handler login = (context) -> {
		Employee em = gson.fromJson(context.body(), Employee.class);
		
		boolean login = false;
		login = ls.login(em);
		
		if(login == true) {
			context.result("Successful Login!");
		} else {
			context.result("Unsuccessful Login");
		}
	};
	
	public Handler validateLogin = (context) -> {
		Employee em = gson.fromJson(context.body(), Employee.class);
		
		boolean login = false;
		login = ls.login(em);
		
		if(login == true) {
			context.result("Successful Login!");
		} else {
			context.result("Unsuccessful Login");
		}
	};
	
}
