package dev.clay.repositories;

import java.util.List;

import dev.clay.models.Reimbursement;

public interface ReimbursementRepo {

	public Reimbursement getReimbursement(int id);
	
	public List<Reimbursement> getAllReimbursements();
	
	public Reimbursement addReimbursement(Reimbursement r);
	
	public Reimbursement updateReimbursement(Reimbursement change);
	
	public Reimbursement deleteReimbursement(int id);
	
}
