import java.io.*;
import java.util.*;

public class Day135
{
	public static void main(String[] args)
	{
		TreeNode root         = new TreeNode(10);
		root.left             = new TreeNode(5);
		root.right            = new TreeNode(5);
		root.left.right       = new TreeNode(2);
		root.right.right      = new TreeNode(1);
		root.right.right.left = new TreeNode(-1);

		int result = minimumSumRtoL(root);
		System.out.println(result);
	}
	public static int minimumSumRtoL(TreeNode r)
	{
		if(r == null) return 0;
		if(r.left == null && r.right == null) return r.val;

		int[] ret = new int[1];
		ret[0] = Integer.MAX_VALUE;
		minimumSumRtoLHelper(r, 0, ret);
		return ret[0];
	}
	private static void minimumSumRtoLHelper(TreeNode r, int curr, int[] ret)
	{
		if(r == null) return;
		if(r.left == null && r.right == null)
		{
			if(curr < ret[0]) ret[0] = curr;
			return;
		}

		curr+=r.val;
		minimumSumRtoLHelper(r.left, curr, ret);
		minimumSumRtoLHelper(r.right, curr, ret);
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