import java.io.*;
import java.util.*;

public class Day112
{
	public static void main(String[] args)
	{
		TreeNode root                = new TreeNode(20);
		root.left                    = new TreeNode(8);
		root.left.parent             = root;
		root.right                   = new TreeNode(22);
		root.right.parent            = root;
		root.left.left               = new TreeNode(4);
		root.left.left.parent        = root.left;
		root.left.right              = new TreeNode(12);
		root.left.right.parent       = root.left;
		root.left.right.left         = new TreeNode(10);
		root.left.right.left.parent  = root.left.right;
		root.left.right.right        = new TreeNode(14);
		root.left.right.right.parent = root.left.right;

		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.parent = root;
		root.right = new TreeNode(3);
		root.right.parent = root;
		root.left.left = new TreeNode(4);
		root.left.left.parent = root.left;
		root.left.right = new TreeNode(5);
		root.left.right.parent = root.left;
		root.right.left = new TreeNode(6);
		root.right.left.parent = root.right;
		root.right.right = new TreeNode(7);
		root.right.right.parent = root.right;*/

		TreeNode result = findLCA(root, root.left, root.left.left);
		if(result != null) System.out.println(result.val);
	}
	public static TreeNode findLCA(TreeNode r, TreeNode n1, TreeNode n2)
	{
		int d1 = depth(n1);
		int d2 = depth(n2);
		int diff = d1-d2;
		if(diff < 0)
		{
			TreeNode temp = n1;
			n1 = n2;
			n2 = temp;
			diff = -diff;
		}

		while(diff != 0)
		{
			diff--;
			n1 = n1.parent;
		}

		while(n1 != null && n2 != null)
		{
			if(n1 == n2) return n1;
			n1 = n1.parent;
			n2 = n2.parent;
		}
		return null;
	}
	private static int depth(TreeNode n)
	{
		int d = -1;
		while(n != null)
		{
			d++;
			n = n.parent;
		}
		return d;
	}
}

class TreeNode
{
	int val;
	TreeNode left, right, parent;
	TreeNode(int a)
	{
		val = a;
		left = null;
		right = null;
		parent = null;
	}
}