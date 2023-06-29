package IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Employee;

public interface IOUtils {

	// store// serialization
	 static void storeempdetails(String filename,Map<String,Employee> emp) {
	
	try(ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename))))
	{
	out.writeObject(emp);	
	}
	catch(Exception e)
	
	{
		e.printStackTrace();
	}
	
	
	
	
}

	 //restore deserialization
	 
	 
	 @SuppressWarnings("unchecked")
	static Map<String,Employee> restoreempdetails(String Filename)
	 {
		 
		 try(ObjectInputStream in =new ObjectInputStream(new BufferedInputStream(new FileInputStream(Filename))))
		 {
			 return  (Map<String, Employee>) in.readObject();
			 
		 }
		 catch(Exception e)
		 {
			//e.printStackTrace();
			System.out.println("Exception occured in deserialization");
			return  new HashMap<String, Employee>();
		 }
		
	
		 
		 
	 }
	 
	 
	 
	 
}