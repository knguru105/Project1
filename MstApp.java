package com.ominiwyse.assignment5;

public class MstApp
{
	
		public static void main(String[] args) 
		{
			Mst m=new Mst();
			m.addVertex('A');
			m.addVertex('B');
			m.addVertex('C');
			m.addVertex('D');
			m.addVertex('E');
			m.addEdge(0, 1);
			m.addEdge(0, 2);
			m.addEdge(0, 3);
			m.addEdge(1, 2);
			m.addEdge(1, 3);
			m.addEdge(1, 4);
			m.addEdge(2, 3);
			m.addEdge(2, 4);
			m.addEdge(3, 4);
			System.out.println("MST");
			m.mst();
		}
	
}
