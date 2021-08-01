package dev.clay.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.clay.models.Reimbursement;
import dev.clay.services.ReimbursementService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReimbursementController {

	ReimbursementService rs;
	Gson gson = new Gson();

	public ReimbursementController(ReimbursementService rs) {
		this.rs = rs;
	}

	public Handler getAllReimbursements = (context) -> {

		String name = context.queryParam("name", "");

		if (name == "") {
			List<Reimbursement> reimbursements = rs.getAllReimbursements();
			if (reimbursements != null) {
				context.result(gson.toJson(reimbursements));
			} else {
				context.result("[ ]");
			}

		}
	};

	public Handler getReimbursementById = (context) -> {

		String input = context.pathParam("id");
		int id;

		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Reimbursement r = rs.getReimbursement(id);

		populate(context, r);
	};

	public Handler addReimbursement = (context) -> {
		Reimbursement r = gson.fromJson(context.body(), Reimbursement.class);

		r = rs.addReimbursement(r);

		populate(context, r);
	};

	public Handler updateReimbursement = (context) -> {

		Reimbursement r = gson.fromJson(context.body(), Reimbursement.class);
		r.setId(Integer.parseInt(context.pathParam("id")));

		r = rs.updateReimbursement(r);

		populate(context, r);
	};

	public void populate(Context context, Reimbursement r) {

		if (r != null) {
			context.result(gson.toJson(r));
		} else {
			context.result("{ }");
		}
	}
}
