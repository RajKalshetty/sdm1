package corejava_233053;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable{

	private String rollno;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private Course course;
	private Qualification qualify;
	private LocalDate dob;
	private double fees;
	private boolean isDocSubmitted;
	
	

	public Student(String rollno, String firstname, String lastname, String email, String address, Course course,
			Qualification qualify, LocalDate dob, double fees) {
		super();
		this.rollno = rollno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.course = course;
		this.qualify = qualify;
		this.dob = dob;
		this.fees = fees;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isDocSubmitted() {
		return isDocSubmitted;
	}

	public void setDocSubmitted(boolean isDocSubmitted) {
		this.isDocSubmitted = isDocSubmitted;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Qualification getQualify() {
		return qualify;
	}

	public void setQualify(Qualification qualify) {
		this.qualify = qualify;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", address=" + address + ", dob=" + dob + ", fees=" + fees + ", isDocSubmitted=" + isDocSubmitted
				+ "]";
	}
	
	
	
	
	
	
	
}
