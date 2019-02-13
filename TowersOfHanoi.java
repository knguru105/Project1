package Assingment1;

import java.util.Scanner;

public class TowersOfHanoi 
{
	public int hanoi(int n, String first, String middle, String last) {
	       if (n == 1)
	       {
	           System.out.println(first + " -> " + last);
	           
	       } 
	       else
	       {
	           hanoi(n - 1, first, last, middle);
	           System.out.println(first + " -> " + last);
	           hanoi(n - 1, middle, first, last);
	       }
	       return 0;
	      
	   }

	   public static void main(String[] args) {
	       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
	       System.out.print("Enter number of discs: ");
	       Scanner scanner = new Scanner(System.in);
	       int discs = scanner.nextInt();
	       towersOfHanoi.hanoi(discs, "A", "B", "C");
	   }

}
