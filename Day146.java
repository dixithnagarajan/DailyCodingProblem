import java.io.*;
import java.util.*;

public class Day146
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(0);
		root.right.left.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		TreeNode result = pruneBinary(root);
		inOrder(result);
		System.out.println();
		preOrder(result);
	}
	public static TreeNode pruneBinary(TreeNode r)
	{
		TreeNode ret = r;
		boolean makeNULL = pruneBinaryHelper(r);
		if(makeNULL) return null;
		return ret;
	}
	private static boolean pruneBinaryHelper(TreeNode r)
	{
		if(r == null) return true;

		boolean left = pruneBinaryHelper(r.left);
		boolean right = pruneBinaryHelper(r.right);

		if(left)
		{
			r.left = null;
		}
		if(right)
		{
			r.right = null;
		}

		return left&&right&&(r.val == 0);
	}
	private static void inOrder(TreeNode r)
	{
		if(r == null) return;
		inOrder(r.left);
		System.out.print(r.val+" ");
		inOrder(r.right);
	}
	private static void preOrder(TreeNode r)
	{
		if(r == null) return;
		System.out.print(r.val+" ");
		preOrder(r.left);
		preOrder(r.right);
	}
}

class TreeNode
{
	int val;
	TreeNode left, right;
	TreeNode(int a)
	{
		val = a;
		left = right = null;
	}
}
