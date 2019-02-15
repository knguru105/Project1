package Assignment2;
import java.util.*;
class Queue 
{
	private int arr[];         // array to store queue elements
	private int front;         // front points to front element in the queue
	private int rear;          // rear points to last element in the queue
	private int capacity;      // maximum capacity of the queue
	private int count;         // current size of the queue
	
	// Constructor to initialize queue
	Queue(int size)
	{
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	
	public void dequeue()
	{
		
		if (isEmpty())
		{
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		}

		System.out.println("Removing " + arr[front]);

		front = (front + 1) % capacity;
		count--;
	}

	
	public int enqueue(int item)
	{
		
		if (isFull())
		{
			System.out.println("OverFlow\nProgram Terminated");
			System.exit(1);
		}

		System.out.println("Inserting " + item);

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		return count++;
	}

	public int size()
	{
		return count;
	}

	
	public Boolean isEmpty()
	{
		return (size() == 0);
	}

	
	public Boolean isFull()
	{
		return (size() == capacity);
	}
	
	public static void main (String[] args)
	{
		
		Queue q = new Queue(5);

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		
		System.out.println("Queue size is " + q.size());

		q.dequeue();
		q.dequeue();
		//q.dequeue();
		System.out.println("Queue size is " + q.size());
		
		if (q.isEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");
	}
}


