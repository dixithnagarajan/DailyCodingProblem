import java.io.*;
import java.util.*;

public class Day117
{
	public static void main(String[] args)
	{
		/*TreeNode root    = new TreeNode(4);
		root.left        = new TreeNode(2);
		root.right       = new TreeNode(-3);
		root.left.left   = new TreeNode(-1);
		root.left.right  = new TreeNode(3);
		root.right.left  = new TreeNode(-2);
		root.right.right = new TreeNode(6);*/

		TreeNode root          = new TreeNode(1);
		root.left              = new TreeNode(2);
		root.right             = new TreeNode(3);
		root.left.left         = new TreeNode(4);
		root.left.right        = new TreeNode(5);
		root.right.right       = new TreeNode(8);
		root.right.right.left  = new TreeNode(6);
		root.right.right.right = new TreeNode(7);

		int result = minSumLevel(root);
		System.out.println(result);
	}
	public static int minSumLevel(TreeNode r)
	{
		if(r == null) return -1;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(r);
		q.add(null);
		int level = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int ret = 0;
		while(!q.isEmpty())
		{
			TreeNode t = q.removeFirst();
			if(t == null)
			{
				if(min > sum)
				{
					min = sum;
					ret = level;
				}
				level++;
				sum = 0;
				if(!q.isEmpty()) q.add(null);
			}
			else
			{
				sum += t.val;
				if(t.left != null) q.add(t.left);
				if(t.right != null) q.add(t.right);
			}
		}
		return ret;
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