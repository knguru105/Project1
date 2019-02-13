package StringProblem;

public class FirstCharacterOccurances 
{
	public static void main(String[] args)
	{
		int result=findInStr("collection",'e');
		System.out.println(result);
	}
	public static int findInStr(String s1, char c)
	{
		for (int i = 0; i < s1.length(); i++) 
		{
		    if (s1.charAt(i) == c) 
		        return i;
		}
		return -1;
	}
}