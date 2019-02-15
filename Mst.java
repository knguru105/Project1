package com.ominiwyse.assignment5;

import java.util.Stack;

class Vertex
{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab)
	{
		label=lab;
		wasVisited=false;
	}
}
class Mst 
{
	private final int MAX_VERTS=20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack<Integer> s;
	
	public Mst()
	{
		vertexList= new Vertex[MAX_VERTS];
		adjMat= new int[MAX_VERTS][MAX_VERTS];
		nVerts=0;
		s=new Stack<Integer>();
			
	}
	public int addVertex(char lab)
	{
		vertexList[nVerts++]=new Vertex(lab);
		return lab;
		
		
	}
	public void addEdge(int start, int end)
	{
		adjMat[start][end]=1;

		adjMat[end][start]=1;
	}
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	public int getAdjUnvisitedVertex(int v)
	{
		for (int i = 0; i < nVerts; i++)
		{
			if(adjMat[v][i]==1 && vertexList[i].wasVisited==false)
			{
				return i;
			}
		}
		return -1;
	}

		public void mst()
		{
			vertexList[0].wasVisited=true;
			s.push(0);
			
			while(!s.isEmpty())
			{
				int current=s.peek();
				int v=getAdjUnvisitedVertex(current);
				
				if(v==-1)
				{
					s.pop();
				}
				else
				{
					vertexList[v].wasVisited=true;
					displayVertex(current);
					displayVertex(v);
					System.out.print(" ");
					s.push(v);
				}
			}
		}
		
	
}