package corejava_233053;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class IOUtils {
	
	public static void storedetails(String filename,Map<String,Student> maplist) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(maplist);
		}
	}
	
	public static Map<String,Student> restoredetails(String filename)
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename)))
		{
			Map<String,Student> restoredlist=(Map<String, Student>) in.readObject();
			return restoredlist;
		}catch (Exception e) {
			System.out.println("De-serialization error"+e);
			return null;	
		}
	}

}
