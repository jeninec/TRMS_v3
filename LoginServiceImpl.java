package dev.clay.services;

import dev.clay.models.Employee;
import dev.clay.repositories.LoginRepo;

public class LoginServiceImpl implements LoginService {

	LoginRepo lr;
	
	
	
	public LoginServiceImpl(LoginRepo lr) {
		super();
		this.lr = lr;
	}


	@Override
	public boolean login(Employee em) {
		return lr.login(em);
	}

}
