package Testing;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static IOUtils.IOUtils.*;
import static Vallidation.VallidationRules.vallidateall;


import com.app.core.Employee;

import Custom_exceptions.EmpHandlingException;

public class Tester {

	public static void main(String[] args) {
		// Map<String ,Employee>emp=new HashMap<>();
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Employee> emp = new HashMap<>();
			System.out.println("enter the filelocation");
			String filename  = sc.next();
			System.out.println();
			File f1 = new File(filename );

			if (f1.isFile() && f1.canRead() && f1.length() != 0) {
				emp = restoreempdetails(filename);

			} else {
				System.out.println("File is Empty...");
			}
			
			boolean exit = false;
			while (!exit) {
				System.out.println("Enter the choice\n\r" + "1. Hire employee\n\r" +
			"2.remove employee\n\r"
						+ "3. display details of all the employees\n\r" + 
			"4. sort on the basis of joiningdate\n\r"
						+ "5. Promote the employee\n\r" +
			"0. exit");
				try {
					switch (sc.nextInt()) {
					case 1:// add emp
						System.out.println("Enter firstname,  lastname,id,dept, joindate,  salary");
						vallidateall(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), emp);

						System.out.println("employee added successfully");

						break;
					case 2:
						System.out.println("Enter the emp id");
					String id = sc.next();
					//emp.getId
					Employee temp = emp.remove(id); //List:because remove method removed element from that index nd returns the removed element 
			//return null if map doesnot contain any maping related to that key so cheched over here		  
					 if( temp!=null)
					{
						   System.out.println(temp); //temp has value associated to that key
						System.out.println("Employee removed successfully");
					}
					else
						throw new EmpHandlingException("id not present/employee not found");
						break;
					case 3:
						emp.forEach((k,v)->System.out.println(v));
						break;
					case 4://sort
						emp.values().stream().sorted((e1,e2)->e1.getJoindate().compareTo(e2.getJoindate())).forEach((v)->System.out.println(v));
						break;
					case 5://promote salary
						System.out.println("Enter employee id");
						 id=sc.next();
						//if(id1==emp.get()){
						
						double sal=emp.get(id).getSalary();
						        emp.get(id).setSalary(sal*1.1); 
					     System.out.println("Promoted successfully");
						//else throw new EmpHandlingException("invalid id");
						break;
					case 0://exit
						System.out.println("Exit..");
						storeempdetails( filename,emp);
						System.out.println("Data stored successfully");
						exit=true;
						break;
					default:
						System.out.println("Invalid input");
						
						break;
					}
				} catch (Exception e)

				{
					e.printStackTrace();
					sc.nextLine();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
