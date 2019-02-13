package Assingment1;

public class PowerOfN 
{
	 static  int power(int x, int n) 
	    { 
	        if (n == 0) 
	            return 1; 
	        else if (n % 2 == 0) 
	            return power(x, n / 2) * power(x, n / 2); 
	        else
	            return x * power(x, n / 2) * power(x, n / 2); 
	    } 
	
	    
	    public static void main(String[] args) 
	    { 
	        int x = 2; 
	        int n = 3; 
	        
	  
	       System.out.printf("%d", power(x, n)); 
	        
	    } 
}
