package dev.clay.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dev.clay.models.Employee;
import dev.clay.util.HibernateUtil;

public class EmployeeRepoImpl implements EmployeeRepo {

	@Override
	public Employee getEmployee(int id) {
		Session sess = HibernateUtil.getSession();
		Employee em = null;
		
		try {
			em = sess.get(Employee.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return em;
	}

	@Override
	public Employee getEmployee(String username) {
		Session sess = HibernateUtil.getSession();
		Employee em = null;
		
		try {
			
			@SuppressWarnings("deprecation")
			Criteria crit = sess.createCriteria(Employee.class);
			crit.add(Restrictions.eq("username", username));
			if (crit.list().size() > 0) {
				em = (Employee) crit.list().get(0);
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session sess = HibernateUtil.getSession();
		List<Employee> employees = null;
		
		try {
			employees = sess.createQuery("FROM Employee").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return employees;
	}

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee change) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
