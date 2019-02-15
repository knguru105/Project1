package Assignment2;

import java.util.Scanner;
import java.util.Stack;

public class WordReverse
{
	
	public String wordReverse(String str1)
	{
		
		Stack<String> wordStack=new Stack<String>();
		
		
		String[] s=str1.split(" ");
		
		for(String word:s)
		{
			wordStack.push(word);
		}
		System.out.println("Reverse Text line");
		String result="";
		while(wordStack.empty()==false)
		{
			result=wordStack.pop();
			System.out.print(result+" ");
		}
		System.out.println();
		
		return result;
		
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Text");
		String str1=sc.nextLine();
		
		WordReverse wr=new WordReverse();
		wr.wordReverse(str1);
    }
}
