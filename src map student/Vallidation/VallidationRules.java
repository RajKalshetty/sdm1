package Vallidation;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Department;
import com.app.core.Employee;

import Custom_exceptions.EmpHandlingException;

public class VallidationRules {

	// all static methods in one-go
	
	//write constructor:String firstname, String lastname, String id, Department dept, LocalDate joindate, double salary
public static Map<String,Employee> vallidateall(String firstname, String lastname, String id,String dept, String joindate, double salary,Map<String,Employee>newemp) throws EmpHandlingException
	{
	CheckDups(id,newemp);
	Department vedept = parseandvallidatedept(dept);
	LocalDate vdate = parseandvallidatedate(joindate);
	newemp.put(id, new Employee(firstname, lastname, id, vedept, vdate, salary));
	
		return newemp;
		
		
	}

	// check for duplicates
	public static void CheckDups(String id,Map<String,Employee>emp) throws EmpHandlingException {
      if(emp.containsKey(id)) {
    	 throw new EmpHandlingException("employee already present"); 
      } 
	}

	// enum vallidation
	public static Department parseandvallidatedept(String dept) {
		return Department.valueOf(dept.toUpperCase());
	}

	// date Vallidation
	public static LocalDate parseandvallidatedate(String joindate) throws EmpHandlingException

	{
		LocalDate vdate = LocalDate.parse(joindate);
		if (vdate.isBefore(LocalDate.now())) {
			throw new EmpHandlingException("invalid date");
		}
		return vdate;
	}

}

