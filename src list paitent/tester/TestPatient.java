package tester;

import java.util.List;
import java.util.Scanner;
import com.code.Patient;
import com.code.RoomType;

import static utils.IOUtils.*;
import static utils.ValidationRules.*;

public class TestPatient {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name : ");
			String fName = sc.next();
			List<Patient> hospitalList = restorePatientDetails(fName);
			System.out.println("restored patient details : " + hospitalList);

			boolean exit = false;

			while (!exit) {
				try {
					System.out.println("Enter \n1.accept Patient Details  \n2.display all Patient Details  "
							+ "\n3.Display Patient by room type  \n4.change roomType special to semi_special  "
							+ "\n5.remove diabetese patients  \n6.sort based on gender  \n0.exit  ");
					System.out.println("Enter choice : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter  serialNo,  name,  admitDate,  disease,  gender,\r\n"
								+ "income,  roomType, hospitalList");
						Patient p = validateAll(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), hospitalList);
						hospitalList.add(p);
						System.out.println("Patient added successfully!");
						break;
					
					case 2:
						hospitalList.forEach(s -> System.out.println(s));						
						break;
					
					case 3:
						System.out.println("enter room type : ");
						RoomType room = parseAndValidateRoom(sc.next());
						hospitalList.stream().filter(s -> s.getRoomType() == room).forEach(s -> System.out.println(s));
						break;
				
					case 4:
						hospitalList.stream().filter(s -> s.getRoomType() == RoomType.SPECIAL)
								.forEach(s -> s.setRoomType(RoomType.SEMI_SPECIAL));
						break;
				
					case 5:
						hospitalList.removeIf(s -> s.getDisease().equalsIgnoreCase("diabetese"));
						break;
				
					case 6:
						hospitalList.stream().sorted((s1, s2) -> s1.getGender().compareTo(s2.getGender()))
								.forEach(s -> System.out.println(s));
						break;
					
					case 0:
						exit = true;
						storePatientDetails(fName, hospitalList);
						System.out.println("stored list");
						break;
					}// switch end
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				} // catch end

			}
		} catch (Exception e) {
			e.printStackTrace();
		} // try with res end
	}
}

//1 John 2023-05-21 Fever Male 5000 SPECIAL
//1 John 2023-05-21 Fever Male 5000 SPECIAL
//2 Lisa 2023-05-21 Cold Female 4000 SEMI_SPECIAL
//3 David 2023-05-21 Diabetes Male 6000 GENERAL
