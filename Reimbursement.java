package dev.clay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursements")
public class Reimbursement {

	@Id
	@Column(name="re_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String justification;
	
	@Column(name="time_out")
	private long timeOut;
	
	private String status;
	
	private String event_type;
	
	@Column(name="start_date")
	private long startDate;
	
	@Column(name="end_date")
	private long endDate;
	
	@Column(name="re_location")
	private String location;
	
	@Column(name="re_cost")
	private double cost;
	
	private int coverage;
	
	private String description;
	
	@Column(name="grading_format")
	private String gradingFormat;
	
	private String cutoff;
	
	private String msg;
	
	@Column(name="upload_file")
	private String uploadFile;
	
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;


	public Reimbursement() {
		super();
	}


	public Reimbursement(int id, String justification, long timeOut, String status, String event_type, long startDate,
			long endDate, String location, double cost, int coverage, String description, String gradingFormat,
			String cutoff, String msg, String uploadFile, Employee employee) {
		super();
		this.id = id;
		this.justification = justification;
		this.timeOut = timeOut;
		this.status = status;
		this.event_type = event_type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.cost = cost;
		this.coverage = coverage;
		this.description = description;
		this.gradingFormat = gradingFormat;
		this.cutoff = cutoff;
		this.msg = msg;
		this.uploadFile = uploadFile;
		this.employee = employee;
	}


	public Reimbursement(String justification, long timeOut, String status, String event_type, long startDate,
			long endDate, String location, double cost, int coverage, String description, String gradingFormat,
			String cutoff, String msg, String uploadFile, Employee employee) {
		super();
		this.justification = justification;
		this.timeOut = timeOut;
		this.status = status;
		this.event_type = event_type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.cost = cost;
		this.coverage = coverage;
		this.description = description;
		this.gradingFormat = gradingFormat;
		this.cutoff = cutoff;
		this.msg = msg;
		this.uploadFile = uploadFile;
		this.employee = employee;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getJustification() {
		return justification;
	}


	public void setJustification(String justification) {
		this.justification = justification;
	}


	public long getTimeOut() {
		return timeOut;
	}


	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEvent_type() {
		return event_type;
	}


	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}


	public long getStartDate() {
		return startDate;
	}


	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}


	public long getEndDate() {
		return endDate;
	}


	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getCoverage() {
		return coverage;
	}


	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGradingFormat() {
		return gradingFormat;
	}


	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}


	public String getCutoff() {
		return cutoff;
	}


	public void setCutoff(String cutoff) {
		this.cutoff = cutoff;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", justification=" + justification + ", timeOut=" + timeOut + ", status="
				+ status + ", event_type=" + event_type + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", location=" + location + ", cost=" + cost + ", coverage=" + coverage + ", description="
				+ description + ", gradingFormat=" + gradingFormat + ", cutoff=" + cutoff + ", msg=" + msg
				+ ", uploadFile=" + uploadFile + ", employee=" + employee + "]";
	}
	
	

}
