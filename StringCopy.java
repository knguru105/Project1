package StringProblem;

public class StringCopy
{
	public static void main(String[] args)
	{
		
		String result=stringCopy("Java","C program");
		System.out.println(result);
	}

	public static String stringCopy(String str1, String str2) 
	{
		String src=str1;
		String dest=str2;
		String tmp;
		
		tmp=str1;
		str1=str2;
		str2=tmp;
		
		
		
		return tmp;
	}
	
}
