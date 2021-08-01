package dev.clay.services;

import java.util.List;

import dev.clay.models.Reimbursement;
import dev.clay.repositories.ReimbursementRepo;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementRepo rr;

	public ReimbursementServiceImpl(ReimbursementRepo rr) {
		this.rr = rr;
	}

	@Override
	public Reimbursement getReimbursement(int id) {
		return rr.getReimbursement(id);
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		return rr.getAllReimbursements();
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) {
		return rr.addReimbursement(r);
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement change) {
		return rr.updateReimbursement(change);
	}

	@Override
	public Reimbursement deleteReimbursement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
