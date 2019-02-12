package HeapTree;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MinHeap 
{
	
	private static final int d= 2;
	private int[] heap;
	private int heapSize;
	
	public MinHeap(int capacity){
		heapSize = 0;
		heap = new int[ capacity+1];
		Arrays.fill(heap, -1);
		
	}
	
	public boolean isEmpty(){
		return heapSize==0;
	}
	
	public boolean isFull(){
		return heapSize == heap.length;
	}
	
	
	private int parent(int i){
		return (i-1)/d;
	}
	
	private int Child(int i,int k){
		return d*i+k;
	}
	
		public void insert(int x){
		if(isFull())
			throw new NoSuchElementException("Heap is full, No space to insert new element");
		heap[heapSize++] = x;
		atInserting(heapSize-1);
	}
	
		 public int findMin()
		 {
			 if(isEmpty())
				 throw new NoSuchElementException("Heap is empty.");
			 return heap[0];
		 }
		 
		/* public int deleteMin()
		 {
			 int key=heap[0];
			 deleteAtPosition(0);
			 return key;
		 }*/
	public int deleteAtPosition(int x){
		if(isEmpty())
			throw new NoSuchElementException("Heap is empty, No element to delete");
		int key = heap[x];
		heap[x] = heap[heapSize -1];
		heapSize--;
		atDeleting(x);
		return key;
	}

	
	private void atInserting(int i) {
		int temp = heap[i];
		while(i>0 && temp < heap[parent(i)]){
			heap[i] = heap[parent(i)];
			i = parent(i);
		}
		heap[i] = temp;
	}
	
	
	private void atDeleting(int i){
		int child;
		int temp = heap[i];
		while(Child(i, 1) < heapSize){
			child = minChild(i);
			if(heap[child]<temp){
				heap[i] = heap[child];
			}else
				break;
			
			i = child;
		}
		heap[i] = temp;
	}

	private int minChild(int i) {
		int bestChild = Child(i, 1);
		int k=2;
		int pos = Child(i, k);
		
		while((k<=d)&&(pos<heapSize))
		{
			if(heap[pos]<heap[bestChild])
			{
				bestChild=pos;
			}
			pos=Child(i,k++);
		}
		return bestChild;
	}
	
	public boolean search(int i) 
	 { 
	    int pos=0;
	     
	     if (pos == 0) 
	         return false; 

	     if (pos == heap[i]) 
	         return true; 

	     
	     return search(i); 
	 } 
	
	public void printHeap()
	    {
	        System.out.print("\nHeap = ");
	        for (int i = 0; i < heapSize; i++)
	            System.out.print(heap[i] +" ");
	        System.out.println();
	    }
	
	
	 public static void main(String[] args){
		 
		 Scanner sc= new Scanner(System.in);
		 MinHeap minHeap = new MinHeap(10);
		 minHeap.insert(10);
		 minHeap.insert(20);
		 minHeap.insert(30);
		 minHeap.insert(40);
		 minHeap.insert(100);
		 minHeap.insert(50);
		 minHeap.insert(60);
		 minHeap.insert(70);
		 minHeap.insert(90);
		 minHeap.insert(80);
		 
		 
		 minHeap.printHeap();
		 System.out.println("deleted value is:"+minHeap.deleteAtPosition(5));
		 minHeap.printHeap();
		 System.out.println("The Min value is:\t"+minHeap.findMin());
		 
		 System.out.println("Enter Search Element");
	      int y=sc.nextInt();
	     
	     if (minHeap.search(y)) 
	         System.out.println("your Search Element is present in list:"+y); 
	     else
	         System.out.println("Not Present in list"); 
		 minHeap.search(80);
	 }
}