package com.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
    
	@Column
	@Id
	int id;
	@Column
	String name;
	@Column
	String branch;
	@Column
	String year;
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
	public String getbranch() {
		return branch;
	}
	public void setbranch(String branch) {
		this.branch = branch;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Student() {
		super();
	}
	
	public Student(int id, String name, String branch, String year) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.year = year;
	}
	
	
	
	
}
