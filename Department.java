package dev.clay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	@Column(name="d_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="head")
	private String head;

	public Department() {
		super();
	}

	public Department(int id, String name, String head) {
		super();
		this.id = id;
		this.name = name;
		this.head = head;
	}

	public Department(String name, String head) {
		super();
		this.name = name;
		this.head = head;
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", head=" + head + "]";
	}

}
