package corejava_233053;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentTester {

	public static void main(String[] args) throws StudentException {
		
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter filname to restore data: ");
			String filename=sc.next();
			Map<String,Student> maplist=IOUtils.restoredetails(filename);
			
			try
			{
			boolean exit=false;
			while(!exit)
			{
				System.out.println("Enter option: ");
				int ch= sc.nextInt();
				
				switch(ch)
				{
				case 1:
					//rollno, firstname,lastname, email,address,course,qualify,dob,fees
					
					System.out.println("Enter rollno, firstname,lastname, email,address,course,qualify,dob,fees ");
					Student register=Studentvalidation.Validateallstudents(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),sc.next(),sc.nextDouble());
					
					maplist.put(register.getRollno(), register);
					System.out.println("Student added successfully");
					break;
					
				case 2:
					for(Student s:maplist.values())
					{
						System.out.println(s);
					}
					break;
				case 3:
					
					//maplist.values().removeIf(s -> !s.isDocSubmitted())	
					break;
					
				case 4:
					System.out.println("Enter city to find students: ");
					String city=sc.next();
					
					maplist.values()
					.stream()
					.filter(s -> s.getAddress().contains(city))
					.forEach(s1 -> System.out.println(s1));
					break;
					
				case 5:
					maplist.values()
					.stream()
					.sorted((s1,s2) -> s1.getDob().compareTo(s2.getDob()));
					break;
					
				case 6:
					maplist.values()
					.stream()
					.filter(s1 -> s1.getFees()<70000)
					.forEach(s1 -> System.out.println(s1.getEmail()));
					break;
					
				case 0:
					
					IOUtils.storedetails(filename,maplist);
					System.out.println("Data stored successfully");
					exit = true;
					break;
					
				default:
					System.out.println("!Enter correct choices!");
					break;
					
				}
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
				
			
		}

	}

}
