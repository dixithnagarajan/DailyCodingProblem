import java.io.*;
import java.util.*;

public class Day36
{
	public static void main(String[] args) throws IOException
	{
		TreeNode root    = new TreeNode(50);
		root.left        = new TreeNode(30);
		root.right       = new TreeNode(70);
		root.left.left   = new TreeNode(20);
		root.left.right  = new TreeNode(40);
		root.right.left  = new TreeNode(60);
		root.right.right = new TreeNode(80);

		secondMax(root);
	}
	public static void secondMax(TreeNode r)
	{
		if(r == null) return;
		if((r.left == null) && (r.right == null)) return;
		int[] count = new int[1];
		secondMax(r, count);
	}
	private static void secondMax(TreeNode r, int[] c)
	{
		if(r == null || c[0] >= 2) return;
		secondMax(r.right, c);
		c[0]++;
		if(c[0] == 2)
		{
			System.out.println(r.val);
			return;
		}
		secondMax(r.left, c);
	}

}

class TreeNode
{
	TreeNode left, right;
	int val;
	TreeNode(int a)
	{
		left = null;
		right = null;
		val = a;
	}
}