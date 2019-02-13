package Assingment1;

public class Pallindrome 
{
	public static void main(String[] args)
	{
		
		System.out.println("String is pallindrome\t"+isStringPalindrome("nitin"));
		System.out.println("String is pallindrome\t"+isStringPalindrome("aai"));
		
	}
	
	public static boolean isStringPalindrome(String input)
	{
	    if(input.length()==0 || input.length()==1)
	    {
	        return true;
	    }
	    int first = 0;
	    int last = input.length()-1;

	    if(input.charAt(first) != input.charAt(last))
	    {
	        return false;
	    }
	    String str="";
	    for(int i=first+1;i<last;i++)
	    {
	        str = str+input.charAt(i); 
	    }
	    boolean result = isStringPalindrome(str);
	    return result; 
	}
}
