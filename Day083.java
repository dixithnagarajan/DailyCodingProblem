import java.io.*;
import java.util.*;

public class Day83
{
	public static void main(String[] args)
	{
		TreeNode root   = new TreeNode(1);
		root.left       = new TreeNode(2);
		root.right      = new TreeNode(3);
		root.left.left  = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		inOrder(root);
		System.out.println();

		TreeNode invertedRoot = invert(root);
		
		inOrder(invertedRoot);
		System.out.println();
	}
	public static TreeNode invert(TreeNode r)
	{
		if(r == null) return r;
		if((r.left == null) && (r.right == null)) return r;

		TreeNode left = invert(r.right);
		r.right = invert(r.left);
		r.left = left;
		return r;
	}
	private static void inOrder(TreeNode r)
	{
		if(r == null) return;
		inOrder(r.left);
		System.out.print(r.val+" ");
		inOrder(r.right);
	}
}

class TreeNode
{
	TreeNode left, right;
	int val;
	TreeNode(int x)
	{
		val = x;
		left = right = null;
	}
}