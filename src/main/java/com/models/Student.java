package com.models;

public class Student {
int id;
String name;
String branch;
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
public String getBranch() {
	return branch;
}
public void getBranch(String branch) {
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
