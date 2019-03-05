package omniwyse.bubble_sort;

import java.util.Scanner;
public class App 
{
   /*public static void main( String[] args )
	    {
	    	App a=new App();
	    	Scanner sc = new Scanner(System.in);
	        
	    	System.out.println("Enter n Elment");
	    	int n =sc.nextInt();
	    	int arr[]=new int[n];
	        //int arr[]= {34,15,29,8};
	        int len =arr.length;
	        for(int i=0;i<len;i++)
	        {
	        	arr[i]=sc.nextInt();
	        }
	        a.bubble_sort(arr,len);
	        System.out.println("sorting element");
	        for(int i=0;i<len;i++)
	        {
	        	System.out.println(arr[i]);
	        }
	    }*/
  
	   /* static  int[] bubble_sort(int arr[],int n)
	    {
	    	int[]res=new int[n];
			int temp,round,i=0;
			for(round=1;round<=n-1;round++)
			{
				for(i=0;i<=n-1-round;i++)
				{
					if(arr[i]>arr[i+1])
					{
						temp=arr[i];
						arr[i]=arr[i+1];
						arr[i+1]=temp;
						res[i]=arr[i+1];
					}
				}
			}
			return res;
	    	
	    }*/

	public int[] sorting_array(int[] arr,int size)
	{
		int temp=0;
		for(int i=0;i<size;i++)
		{
			for(int j=1;j<(size-i);j++)
			{
				if(arr[j-1]>arr[j])
				{
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
    
}
