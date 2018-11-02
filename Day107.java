import java.io.*;
import java.util.*;

public class Day107
{
	public static void main(String[] args)
	{
		TreeNode root    = new TreeNode(1);
		root.left        = new TreeNode(2);
		root.right       = new TreeNode(3);
		root.right.left  = new TreeNode(4);
		root.right.right = new TreeNode(5);

		levelPrint(root);
	}
	public static void levelPrint(TreeNode r)
	{
		if(r == null) return;
		if(r.left == null && r.right == null)
		{
			System.out.println(r.val);
			return;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(r);
		q.add(null);
		while(!q.isEmpty())
		{
			TreeNode t = q.removeFirst();
			if(t == null)
			{
				if(!q.isEmpty()) q.add(null);
				continue;
			}
			System.out.print(t.val+" ");
			if(t.left!=null) q.add(t.left);
			if(t.right!=null) q.add(t.right);
		}
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