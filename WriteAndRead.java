package WriteReadBinaryfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteAndRead 
{
	static String filename="C:\\Users\\user\\Desktop\\binary.bin";
	
	public static void main(String[] args)
	{
		WriteAndRead.writeData(filename);
		WriteAndRead.readData(filename);
		
		boolean isDeleted = deleteFile(filename);
		if (isDeleted)
		{
			System.out.println("Data Deleted successfully!!");
		}else
		{
			System.out.println("data Deletion failure due to file not exist or file permissions !!");
		}
	}
	public static String writeData(String filename)
	{
		EmployeeData emp= new EmployeeData(1,"GURU","Trainee",2.4);
		System.out.println("Writing Employee Details");
		System.out.println("Id\t\t"+emp.Id);
		System.out.println("Name\t\t"+emp.Name);
		System.out.println("Designation\t"+emp.Desiganation);
		System.out.println("Package\t\t"+emp.Package);
	
		try 
		{
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream os=new ObjectOutputStream(fos);
			
			os.writeObject(emp);
			
			os.close();
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("******************************************************");
		return filename;
		
	}
	public static String readData(String filename)
	{
		try 
		{
			FileInputStream fin= new FileInputStream(filename);
			ObjectInputStream is=new ObjectInputStream(fin);
			EmployeeData emp2=(EmployeeData) is.readObject();
			System.out.println("Reading Employee Details");
			System.out.println("Id\t\t"+emp2.Id);
			System.out.println("Name\t\t"+emp2.Name);
			System.out.println("Designation\t"+emp2.Desiganation);
			System.out.println("Package\t\t"+emp2.Package);
			is.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}
	public static boolean deleteFile(String filePath)
	{
		File file = new File(filePath);
		boolean result = file.delete();
		return result;

	}
	
}
