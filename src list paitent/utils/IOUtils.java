package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.code.Patient;

public interface IOUtils {
	static void storePatientDetails(String fName, List<Patient> hosptaList) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fName)))) {
			oos.writeObject(hosptaList);
		}
	}

	@SuppressWarnings("unchecked")
	static List<Patient> restorePatientDetails(String fName) {
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fName)))) {
			return (List<Patient>) ois.readObject();
		} catch (Exception e) {
			System.out.println("empty list");
			return new ArrayList<>();
		}
	}
}
