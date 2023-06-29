package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Employee implements Serializable{

	private String firstname;
	private String lastname;
	private String id;
	private Department dept;
	private LocalDate joindate;
	private double salary;
	
	
	
	
	
	
	public Employee(String firstname, String lastname, String id, Department dept, LocalDate joindate, double salary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.dept = dept;
		this.joindate = joindate;
		this.salary = salary;
	}



	
	
	
	



	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", id=" + id + ", dept=" + dept
				+ ", joindate=" + joindate + ", salary=" + salary + "]";
	}










	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public LocalDate getJoindate() {
		return joindate;
	}






	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}






	public double getSalary() {
		return salary;
	}






	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
	
	
	
}
