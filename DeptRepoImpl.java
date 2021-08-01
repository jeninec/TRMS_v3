package dev.clay.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dev.clay.models.Department;
import dev.clay.util.HibernateUtil;

public class DeptRepoImpl implements DeptRepo {

	public Department getDepartment(int id) {
		Session sess = HibernateUtil.getSession();
		Department d = null;
		
		try {
			d = sess.get(Department.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return d;
	}

	public Department getDepartment(String name) {
		Session sess = HibernateUtil.getSession();
		Department d = null;
		
		try {
			
			@SuppressWarnings("deprecation")
			Criteria crit = sess.createCriteria(Department.class);
			crit.add(Restrictions.eq("name", name));
			if (crit.list().size() > 0) {
				d = (Department) crit.list().get(0);
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return d;
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {
		Session sess = HibernateUtil.getSession();
		List<Department> depts = null;
		
		try {
			depts = sess.createQuery("FROM Department").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return depts;
	}

	public Department addDepartment(Department d) {
		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			d.setId((Integer) sess.save(d));
			sess.getTransaction().commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			d = null;
		} finally {
			sess.close();
		}
		
		return d;
	}

	public Department updateDepartment(Department change) {
		// TODO Auto-generated method stub
		return null;
	}

	public Department deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
