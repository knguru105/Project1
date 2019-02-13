package Assingment1;

import java.util.Scanner;

public class Fibonacci 
{
	
	static int a=0,b=1,c;
	public static void main(String args[])
	{
		System.out.println("Iterative Fibonacci Series");
		System.out.print(a+" "+b);
		Fibonacci fib=new Fibonacci();
		fib.iterativeFib(11);
		System.out.println();
		System.out.println("*******************************");
		
		System.out.println("Recursion Fibonacci Series");
		for(int i=0;i<=10;i++)
		{
			System.out.print(recFib(i)+" ");
		}
	}
	public static int iterativeFib(int n)
	{
		
		for(int i=1;i<=n-2;i++)
		{
			
			c=a+b;
			System.out.print(" "+c);
			a=b;
			b=c;
		
		}
		return c;
	}
	public static int recFib(int n)
	{
		if(n==0)
		{
			return n;
		}
		if(n==1)
		{
			return 1;
		}
		else
		{
			return recFib(n-1)+recFib(n-2);
		}
		
			
	}
	
}		
			
			
			
			
			
			
			
			
			
			