package BSTorNot;

class Node
{
	int data;
	Node left = null, right = null;

	Node(int data)
	{
		this.data = data;
	}
}

class BSTorNot
{
	
	public static Node insert(Node root, int key)
	{
		
		if (root == null)
		{
			return new Node(key);
		}

		if (key < root.data) 
		{
			root.left = insert(root.left, key);
		}
		
		else 
		{
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static boolean isBST(Node node, int low, int high)
	{
		// base case
		if (node == null) {
			return true;
		}

		if (node.data < low || node.data > high) 
		{
			return false;
		}
		return (isBST(node.left, low, node.data) && isBST(node.right, node.data, high));
	}

	//given Binary Tree is a BST or not
	public static void isBST(Node root)
	{
		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("This is a Binary Search Tree.");
		} else {
			System.out.println("This is Not a Binary Search Tree.");
		}
	}

	private static void swap(Node root) {
		Node left = root.left;
		root.left = root.right;
		root.right = left;
	}
	
	
	public static void main(String[] args)
	{
		Node root = null;
		int[] arr = {10,5,16,1,6,15,19};

		for (int key : arr) {
			root = insert(root, key);
		}

		
		swap(root);
		isBST(root);
	}
}