package dev.clay.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.clay.models.Employee;
import dev.clay.util.HibernateUtil;

public class LoginRepoImpl implements LoginRepo {

	@SuppressWarnings("unchecked")
	@Override
	public boolean login(Employee em) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		boolean key = false;
		
		System.out.println("emid: "+em);
		List<Employee> employees = null; 
		try {
			tx = sess.beginTransaction();
			
			employees = sess.createQuery("FROM Employee").list();
			for (Employee emDB : employees) {
				if(em.getUsername().equals(emDB.getUsername()) && em.getPassword().equals(emDB.getPassword())) {
					key = true;
				}
			}
			
			
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			key = false;
		} 
		return key;
	}

}
