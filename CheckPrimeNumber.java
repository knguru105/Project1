package Assingment1;

import java.util.Scanner;

public class CheckPrimeNumber 
{
	public static int checkPrime(int number)
	{
		boolean b=false;//To check true or false
		
		while(number<2)
		{
			b=true;
			//System.out.println(number+"Natural Number");
			break;
		}
		
		for(int i=2;i<number;i++)
		{
			
			if(number%i==0)
			{
				b=true;
				break;
			}
		}
		if(b==true)
		{
			System.out.print("Given Number is:\t"+number+"\tnot a Prime Number");
		}
		else 
		{
			System.out.print("Given Number is:\t"+number+"\tPrime Number");
		}
		return number;
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);//to take user through input
		
		System.out.println("Enter any number");
		int number=sc.nextInt();
		
		System.out.println(checkPrime(number));
		
	}
}
