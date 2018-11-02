import java.io.*;
import java.util.*;

public class Day80
{
	public static void main(String[] args) throws IOException
	{
		TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.right.left = new TreeNode(5); 
        root.right.right = new TreeNode(6); 
        root.right.left.right = new TreeNode(7); 
        root.right.right.right = new TreeNode(8); 
        root.right.left.right.left = new TreeNode(9); 
        root.right.right.right.right = new TreeNode(10); 

		int maxlevel = depth(root);
		TreeNode result = deepestNode(root, maxlevel);
		System.out.println("The deepest node is - "+result.val+" at level "+maxlevel);
	}
	public static TreeNode deepestNode(TreeNode r, int l)
	{
		if((l == 0) && (r != null)) return r;
		else if(l == 0) return null;
		else if(l!=0 && r==null) return null;
		TreeNode left = deepestNode(r.left, l-1);
		TreeNode right = deepestNode(r.right, l-1);
		if(left != null) return left;
		return right;
	}
	public static int depth(TreeNode r)
	{
		if(r == null) return -1;
		return Math.max(1+depth(r.left), 1+depth(r.right));
	}
}

class TreeNode
{
	TreeNode left, right;
	int val;
	TreeNode(int v)
	{
		val = v;
	}
}