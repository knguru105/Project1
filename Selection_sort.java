package Omniwyse.com.Selection_sort;

/**
 * Hello world!
 *
 */
public class Selection_sort 
{
   /* public static void main( String[] args )
    {
    	Selection_sort s=new Selection_sort();
    	int arr[]= {38,52,9,18,6,62,13};
    	int len =arr.length;
    	s.selection_sort(arr, len);
    	for(int i=0;i<len;i++)
		{
			System.out.println(arr[i]);
		}
    	
    	
    }
    public int[] selection_sort(int[] arr, int size)
    {
    	int temp=0,min;
    	
	    	for(int i=0;i<size;i++)
	    	{
		    		min = i;
		    		for(int j=i+1;j<size;j++)
		    		{
		    			if(arr[i]<arr[min])
		    			{
		    				min= j;
		    			}
		    		}
			    		temp=arr[i];
			    		arr[i]=arr[min];
			    		arr[min]=temp;
		    }
			
	    	  
			   
	    	 return arr;
    }*/
	
	public int[] selectionSort(int[] arr)
	   { 
	      // selection sort array java
	      for(int i = 0; i < arr.length - 1; i++)
	      {
	         int index = i;
	         for(int j = i + 1; j < arr.length; j++)
	            if(arr[j] < arr[index]) 
	               index = j;

	         int smallNumber = arr[index]; 
	         arr[index] = arr[i];
	         arr[i] = smallNumber;
	      }
	      return arr;
	   }

	   public static void main(String[] args) 
	   {
		  Selection_sort s = new Selection_sort();
	      int[] arrOne = {10, 23, 32, -14, 27, 45, 36, 21};
	      int[] arrTwo = s.selectionSort(arrOne);
	      for(int x: arrTwo)
	      {
	         System.out.print(x);
	         System.out.print(" ");
	      }
	   }
	
    
		  
}
