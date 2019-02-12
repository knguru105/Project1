package BinaryTree;

class Node
{
	int data;
	Node left;
	Node right;
}
class BST
{	
		 
			public Node createNewNode(int k)
			{
				Node a = new Node();
				a.data=k;
				a.left=null;
				a.right=null;
				return a;
			}
	
	
			
		public Node getSuccessor(Node node)
		{
			if(node==null)
			{
				return null;
			}
			Node tmp=node.right;
			while(tmp!=null)
			{
				tmp=tmp.left;
				
			}
			return tmp;
		}

	public Node insert(Node node,int val)
	{
			if(node==null)
			{
				return createNewNode(val);
			}
			if(val<node.data)
			{
				node.left=insert(node.left,val);
			}
			else if(val>node.data)
			{
				node.right=insert(node.right, val);
			}
			return node;
	}
	
	public Node delete(Node node,int val)
	{
		if(node==null)
		{
			return null;
		}
		if(val<node.data)
		{
			node.left=delete(node.left,val);
		}
		else if(val>node.data)
		{
			node.right=delete(node.right, val);
		}
		else 
		{
				if(node.left==null||node.right==null)
				{
					Node tmp=null;
					tmp=node.left==null ? node.right : node.left;
					
					if(tmp==null)
					{
						return null;
					}
					else
					{
						return tmp;
					}
				}
				
				else 
				{
					Node successor=getSuccessor(node);
					node.data=successor.data;
					node.right=delete(node.right,4);
				}
				
		}
		return node;
	
	}
	
	public void Inorder(Node node)
	{
		if(node==null)
		{
			return;
		}
		Inorder(node.left);
		System.out.print(" "+node.data);
		Inorder(node.right);
	}
	
	public void Preorder(Node node)
	{
		if(node==null)
		{
			return;
		}
		System.out.print(" "+node.data);
		Preorder(node.left);
		Preorder(node.right);
		
	}
	
	public void Postorder(Node node)
	{
		if(node==null)
		{
			return;
		}
		
		
		Preorder(node.left);
		Preorder(node.right);
		System.out.print(" "+node.data);
	}
	
     public int getNumberOfLeafNode(Node node)
     {
    	 if(node==null)
    	 {
    		 return 0;
    	 }
    	 if(node.left==null&&node.right==null)
    	 {
    		 return 1;
    	 }
    	 return getNumberOfLeafNode(node.left) + getNumberOfLeafNode(node.right);
     }
     
     public int getHieghtOfTree(Node node)
     {
    	 if(node==null)
    	 {
    		 return -1;
    	 }
    	 return max(getHieghtOfTree(node.left),getHieghtOfTree(node.right))+1;
     }
     private int max(int a,int b)
     {
    	 return a>b?a:b;
     }
}
public class BSTMain 
{
	public static void main(String[] args) {
		
		BST b=new BST();
		
		Node root=null;
		

		root=b.insert(root,1);
		root=b.insert(root,3);
		root=b.insert(root,4);
		root=b.insert(root,6);
		root=b.insert(root,7);
		root=b.insert(root,8);
		root=b.insert(root,10);
		root=b.insert(root,13);
		root=b.insert(root,14);
		
		
		
		//System.out.println("deleted element : "+b.delete(root,6));
		root=b.delete(root,13);
		
		
		System.out.println("Inorder");
		b.Inorder(root);
		System.out.println();
		System.out.println("Preorder");
		b.Preorder(root);
		System.out.println();
		System.out.println("Postorder");
		b.Postorder(root);
		System.out.println();
		System.out.println("Number of leaf nodes is"+b.getNumberOfLeafNode(root));
		System.out.println("Hieght Of Tree is: "+b.getHieghtOfTree(root.right.right));
	}
}
