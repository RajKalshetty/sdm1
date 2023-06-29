package corejava_233053;

import java.time.LocalDate;

public class Studentvalidation {

	public static Student Validateallstudents(String rollno, String firstname, String lastname, String email, String address, String course,
			String qualify, String dob, double fees) throws StudentException
	{
		LocalDate dateofbirth=parsedate(dob);
		Qualification qualification=parsequalification(qualify);
		Course courses=parsecourse(course);
		
		return new Student(rollno,firstname, lastname,email,address,courses,qualification,dateofbirth, fees);
		
	}
	
	
	public static LocalDate parsedate(String dob) throws StudentException
	{
		String checkdate = "2000-01-01";
		LocalDate date = LocalDate.parse(dob);
		LocalDate date1= LocalDate.parse(checkdate);
		
		if(date.isBefore(date1))
			throw new StudentException("Student is invalid bcoz of DOB!!!!");
		return date;
	}
	
	public static Qualification parsequalification(String qualify) 
	{
		return Qualification.valueOf(qualify.toUpperCase());
	}
	
	public static Course parsecourse(String course) 
	{
		return Course.valueOf(course.toUpperCase());
	}
}
