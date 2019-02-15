package Assignment2;
import java.io.*;
import java.util.Scanner; 
public class LinkedList { 

 Node head; // head of list 

 

 static class Node { 

     int data; 
     Node next; 
    

    
     // Constructor 
     Node(int d) 
     { 
         data = d; 
         next = null; 
        
         
     } 
      
     
 } 


 public  LinkedList insert(LinkedList list, int data) 
 { 
     
     Node new_node = new Node(data); 
     new_node.next = null; 

     
     if (isEmpty()) 
     { 
         list.head = new_node; 
     } 
     else { 
        
         Node last = list.head; 
         while (last.next != null) { 
             last = last.next; 
         } 

         
         last.next = new_node;
        
     } 

     
     return list; 
 } 

 
 public static LinkedList delete(LinkedList list, int key) 
 { 
   
     Node currNode = list.head, prev = null; 

     
   

     if (currNode != null && currNode.data == key) { 
         list.head = currNode.next; // Changed head 

          
         System.out.println(key + " found and deleted"); 

          
         return list; 
     } 

     
     while (currNode != null && currNode.data != key) { 
         
         prev = currNode; 
         currNode = currNode.next; 
     } 

       if (currNode != null) { 
         
         prev.next = currNode.next; 

          
         System.out.println(key + " found and deleted"); 
     } 

     
     if (currNode == null) { 
        
         System.out.println(key + " not found"); 
     } 

      
     return list; 
 } 

  public int size(LinkedList list,Node head)
  {
	  
	  int listSize=0;
	  if(head!=null)
		  listSize=1;
	  while(head.next!=null)
	  {
		  listSize++;
		  head= head.next;
	  }
	  return listSize;
  }

	
	public Boolean isEmpty()
	{
		
		return 	head == null;
	}
	
 public boolean search(Node head, int x) 
 { 
    
     
     if (head == null) 
         return false; 

     if (head.data == x) 
         return true; 

     
     return search(head.next, x); 
 } 
	
 public static void printList(LinkedList list) 
 { 
     Node currNode = list.head; 

     System.out.print("\nLinkedList: "); 

     
     while (currNode != null) 
     { 
          
         System.out.print(currNode.data + " "); 
         currNode = currNode.next; 
     } 
     System.out.println("\n"); 
 } 

 public static void main(String[] args) 
 { 
	 Scanner sc=new Scanner(System.in);
     LinkedList list = new LinkedList(); 

	     list.insert(list, 1); 
	     list.insert(list, 2); 
	     list.insert(list, 3); 
	     list.insert(list, 4); 
	     list.insert(list, 5); 
	     list.insert(list, 6); 
	     list.insert(list, 7); 
	     list.insert(list, 8); 
	     list.insert(list, 9); 
	   
   

    
     printList(list); 

   
     delete(list, 1); 

     printList(list); 
     delete(list, 4); 

      
     printList(list); 
     delete(list, 9); 
     printList(list); 
     System.out.println(list.isEmpty());
     System.out.println("size is:"+list.size(list,list.head));
     
     System.out.println("Enter Search Element");
      int x=sc.nextInt();
     
     if (list.search(list.head, x)) 
         System.out.println("your Search Element is present in list:"+x); 
     else
         System.out.println("Not Present in list"); 
 
 } 
} 
