import java.util.*;
import java.io.*;

public class Day8
{
	public static void main(String[] args) throws IOException
	{
		TreeNode root         = new TreeNode(0);
		root.left             = new TreeNode(1);
		root.right            = new TreeNode(0);
		root.right.left       = new TreeNode(1);
		root.right.right      = new TreeNode(0);
		root.right.left.left  = new TreeNode(1);
		root.right.left.right = new TreeNode(1);

		inOrder(root);
		System.out.println();

		System.out.println("Number of Unival trees are - "+numberOfUnivalTrees(root));
	}

	public static int numberOfUnivalTrees(TreeNode r)
	{
		int[] i = new int[1];
		numberOfUnivalTreesHelper(r, i);
		return i[0];
	}
	private static boolean numberOfUnivalTreesHelper(TreeNode r, int[] i)
	{
		if(r == null) return true;
		if((r.left == null) && (r.right == null))
		{
			i[0]++;
			return true;
		}
		boolean left = numberOfUnivalTreesHelper(r.left, i);
		boolean right = numberOfUnivalTreesHelper(r.right, i);
		if(!left || !right) return false;
		if(r.left!=null && r.left.val!=r.val) return false;
		if(r.right!=null && r.right.val!=r.val) return false;
		i[0]++;
		return true;
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
	TreeNode left,right;
	int val;
	TreeNode(int va)
	{
		val = va;
		left = null;
		right = null;
	}
}