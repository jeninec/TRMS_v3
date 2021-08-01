package dev.clay.app;

import dev.clay.controllers.DeptController;
import dev.clay.controllers.EmployeeController;
import dev.clay.controllers.LoginController;
import dev.clay.controllers.ReimbursementController;
import dev.clay.repositories.DeptRepo;
import dev.clay.repositories.DeptRepoImpl;
import dev.clay.repositories.EmployeeRepo;
import dev.clay.repositories.EmployeeRepoImpl;
import dev.clay.repositories.LoginRepo;
import dev.clay.repositories.LoginRepoImpl;
import dev.clay.repositories.ReimbursementRepo;
import dev.clay.repositories.ReimbursementRepoImpl;
import dev.clay.services.DeptService;
import dev.clay.services.DeptServiceImpl;
import dev.clay.services.EmployeeService;
import dev.clay.services.EmployeeServiceImpl;
import dev.clay.services.LoginService;
import dev.clay.services.LoginServiceImpl;
import dev.clay.services.ReimbursementService;
import dev.clay.services.ReimbursementServiceImpl;
import io.javalin.Javalin;

public class App2 {

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

		establishRoutes(app);

		app.start(7000);

	}

	private static void establishRoutes(Javalin app) {
		// Department DAO and Service Layers
		DeptRepo dr = new DeptRepoImpl();
		DeptService ds = new DeptServiceImpl(dr);
		DeptController dc = new DeptController(ds);

		// Hack to force Hibernate to load upon start
		dr.getDepartment(1);

		// Department Routes
		app.get("/departments", dc.getAllDepartments);
		app.get("/departments/:id", dc.getDepartmentById);

		app.post("/departments", dc.addDepartment);

//		app.put("/departments/:id", dc.updateDepartment);
//		app.delete("/departments/:id", dc.deleteDepartment);

		// Employee DAO and Service Layers
		EmployeeRepo er = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(er);
		EmployeeController ec = new EmployeeController(es);

		// Employee Routes
		app.get("/employees", ec.getAllEmployees);
		app.get("/employees/:id", ec.getEmployeeById);

		// Reimbursement DAO and Service Layers
		ReimbursementRepo rr = new ReimbursementRepoImpl();
		ReimbursementService rs = new ReimbursementServiceImpl(rr);
		ReimbursementController rc = new ReimbursementController(rs);

		// Reimbursement Routes
		app.get("/reimbursements", rc.getAllReimbursements);
		app.get("/reimbursements/:id", rc.getReimbursementById);

		app.post("/reimbursements", rc.addReimbursement);
		app.put("/reimbursements/:id", rc.updateReimbursement);

		// Login DAO and Service Layers
		LoginRepo lr = new LoginRepoImpl();
		LoginService ls = new LoginServiceImpl(lr);
		LoginController lc = new LoginController(ls);

		// Employee Routes
		app.post("/login", lc.validateLogin);
	}

}
