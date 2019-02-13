package Assingment1;

import java.util.Scanner;

public class GcdTwoNumber
{
	public static int GCD(int num1,int num2)
	{
		int gcd=1;
		for(int i=1;i<num1&&i<num2;i++)
		{
			if((num1%i==0)&&(num2%i==0))
			{
			 gcd = i;
			}
			
		}
		return gcd;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter First Number");
		int num1=sc.nextInt();
		System.out.println("Enter second Number");
		int num2=sc.nextInt();
		
		int result=GCD(num1,num2);
		
		System.out.println(result);
		
		
		
	}
}
