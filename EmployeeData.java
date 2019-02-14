package WriteReadBinaryfile;

import java.io.Serializable;

public class EmployeeData implements Serializable

{
	int Id;
	String Name;
	String Desiganation;
	double Package;
	
	EmployeeData(int id,String name,String designation,double pak)
	{
		Id=id;
		Name=name;
		Desiganation=designation;
		Package= pak;
	}
}
