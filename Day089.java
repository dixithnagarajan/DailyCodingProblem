import java.io.*;
import java.util.*;

public class Day89
{
	public static void main(String[] args)
	{
		TreeNode root   = new TreeNode(3);
		root.left       = new TreeNode(2);
		root.right      = new TreeNode(5);
		root.left.left  = new TreeNode(1);
		root.left.right = new TreeNode(4);

		boolean result = isValidBST(root);
		System.out.println(result);
		result = isValidBSTTop(root);
		System.out.println(result);
	}
	//Bottom Up Parsing
	public static boolean isValidBST(TreeNode r)
	{
		Info i = isValidBSTHelper(r);
		return i.isBST;
	}
	private static Info isValidBSTHelper(TreeNode r)
	{
		if(r == null) return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if(r.left == null && r.right == null) return new Info(true, r.val, r.val);

		Info l = isValidBSTHelper(r.left);
		Info ri = isValidBSTHelper(r.right);

		if(l.isBST && ri.isBST && l.max<r.val && ri.min>r.val)
		{
			int max = Math.max(Math.max(r.val, ri.max), l.max);
			int min = Math.min(l.min, Math.min(r.val, ri.min));
			return new Info(true, max, min);
		}
		return new Info(false, 0, 0);
	}
	//Top to Bottom Parsing
	public static boolean isValidBSTTop(TreeNode r)
	{
		return isValidBSTTopHelper(r, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean isValidBSTTopHelper(TreeNode r, int min, int max)
	{
		if(r == null) return true;
		if(r.val<=min || r.val>=max) return false;
		return ((isValidBSTTopHelper(r.left, min, r.val)) && (isValidBSTTopHelper(r.right, r.val, max)));
	}
}

class TreeNode
{
	int val;
	TreeNode left, right;
	TreeNode(int a)
	{
		val = a;
		left = null;
		right = null;
	}
}

class Info
{
	boolean isBST;
	int max;
	int min;
	Info(boolean a, int b, int c)
	{
		max = b;
		min = c;
		isBST = a;
	}
}