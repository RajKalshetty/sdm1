package utils;

import java.time.LocalDate;
import java.util.List;

import com.code.Patient;
import com.code.RoomType;

import custom_exception.InvalidPatientException;

public interface ValidationRules {
	// validate all
	static Patient validateAll(int serialNo, String name, String admitDate, String disease, String gender,
			Double income, String roomType, List<Patient> hospitalList) throws InvalidPatientException {
		checkDuplicate(serialNo, hospitalList);
		LocalDate date = parseAndValidateAdmitDate(admitDate);
		RoomType room = parseAndValidateRoom(roomType);
		return new Patient(serialNo, name, date, disease, gender, income, room);
	}

	// parse and validate date it should be equal to current date
	static LocalDate parseAndValidateAdmitDate(String admitDate) throws InvalidPatientException {
		LocalDate date = LocalDate.parse(admitDate);
		LocalDate curDate = LocalDate.now();
		if (date.equals(curDate))
			return date;
		throw new InvalidPatientException("Invalid admit date!!!!!!");
	}

	// parse and validate room type
	static RoomType parseAndValidateRoom(String roomType) {
//		RoomType room = RoomType.valueOf(roomType.toUpperCase());
//		if(room.getRate())
		return RoomType.valueOf(roomType.toUpperCase());
	}

	// check dup
	static void checkDuplicate(int serialNo, List<Patient> hospitalList) throws InvalidPatientException {
		
//		if(hospitalList != null)
//		{
//			Patient i=new Patient(serialNo);
//			System.out.println("in validation   "+i +"index is"+hospitalList.indexOf(i));
//			int p1=hospitalList.indexOf(i);
//			System.out.println("in validation   "+p1);
//			Patient p2=hospitalList.get(p1);
//			System.out.println("in validation   "+p2);
//		if (hospitalList.contains(p2))
//			throw new InvalidPatientException("duplicate serialNo!!!!!!!!!");
//		System.out.println("no duplicate");
//		}
		
		if(hospitalList!=null)
		{
			Patient p1=new Patient(serialNo);
			if(hospitalList.contains(p1)) {
			throw new InvalidPatientException("duplicate srial no.!!!!!!!");
			}
		}
		
	}
}
