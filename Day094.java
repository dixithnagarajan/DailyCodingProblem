import java.io.*;
import java.util.*;

public class Day94
{
	public static void main(String[] args)
	{
		TreeNode root          = new TreeNode(10);
		root.left              = new TreeNode(2);
		root.right             = new TreeNode(10);
		root.left.left         = new TreeNode(20);
		root.left.right        = new TreeNode(1);
		root.right.right       = new TreeNode(-25);
		root.right.right.left  = new TreeNode(3);
		root.right.right.right = new TreeNode(4);

		int result = findMaxSum(root);
		System.out.println("Maximum path sum is - "+result);
	}
	public static int findMaxSum(TreeNode r)
	{
		int[] res = new int[1];
		findMaxSumHelper(r, res);
		return res[0];
	}
	private static int findMaxSumHelper(TreeNode r, int[] res)
	{
		if(r == null) return 0;
		int l = findMaxSumHelper(r.left, res);
		int ri = findMaxSumHelper(r.right, res);

		int max_single = Math.max(Math.max(l,ri)+r.val, r.val);
		int max_top = Math.max(max_single, l+ri+r.val);
		res[0] = Math.max(res[0], max_top);
		return max_single;
	}
}

class TreeNode
{
	int val;
	TreeNode left, right;
	TreeNode(int a)
	{
		val = a;
	}
}