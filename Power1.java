package Assingment1;

public class Power1 
{
	
		 static int power(int x, int n) 
		    { 
			 if (n == 0)
			        return 1;
			    if (n == 1)
			        return x;
			    else
			        return x * (power(x, n-1)); 
		    } 
		 
		    
		    public static void main(String[] args) 
		    { 
		        int x = 2; 
		        int n = 0; 
		        
		  
		        System.out.printf("%d", power(x, n)); 
		        
		    } 
	 
}
