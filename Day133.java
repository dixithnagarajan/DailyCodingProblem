import java.io.*;
import java.util.*;

public class Day133
{
	public static void main(String[] args)
	{
		/*TreeNode root                = new TreeNode(20);
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
		root.left.right.right.parent = root.left.right;*/

		TreeNode root           = new TreeNode(10);
		root.left               = new TreeNode(5);
		root.left.parent        = root;
		root.right              = new TreeNode(30);
		root.right.parent       = root;
		root.right.left         = new TreeNode(22);
		root.right.left.parent  = root.right;
		root.right.right        = new TreeNode(35);
		root.right.right.parent = root.right;

		TreeNode result = successor(root, root.right.left);
		System.out.println(result.val);
	}

	public static TreeNode successor(TreeNode r, TreeNode n)
	{
		if(r == null || n == null) return null;
		if(n.right != null)
		{
			TreeNode ret = n.right;
			while(ret.left != null)
			{
				ret = ret.left;
			}
			return ret;
		} 

		TreeNode ret = n.parent;
		TreeNode temp = n;
		while(ret != null && ret.left != temp)
		{
			ret = ret.parent;
			temp = temp.parent;
		}
		return ret;
	}
}

class TreeNode
{
	int val;
	TreeNode right, left;
	TreeNode parent;
	TreeNode(int a)
	{
		val = a;
	}
}