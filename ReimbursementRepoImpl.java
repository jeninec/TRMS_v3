package dev.clay.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.clay.models.Reimbursement;
import dev.clay.util.HibernateUtil;

public class ReimbursementRepoImpl implements ReimbursementRepo {

	@Override
	public Reimbursement getReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		Reimbursement r = null;
		
		try {
			r = sess.get(Reimbursement.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reimbursement> getAllReimbursements() {
		Session sess = HibernateUtil.getSession();
		List<Reimbursement> reimbursements = null;
		
		try {
			reimbursements = sess.createQuery("FROM Reimbursement").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) {
Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			r.setId((int)sess.save(r));
			sess.getTransaction().commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			r = null;
		} finally {
			sess.close();
		}
		
		return r;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return change;
	}

	@Override
	public Reimbursement deleteReimbursement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
