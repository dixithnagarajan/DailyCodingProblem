import java.io.*;
import java.util.*;

public class Day115
{
	public static void main(String[] args)
	{
		TreeNode t   = new TreeNode(10);
		t.left       = new TreeNode(4);
		t.right      = new TreeNode(6);
		t.left.right = new TreeNode(30);

		TreeNode s        = new TreeNode(26);
		s.left            = new TreeNode(10);
		s.right           = new TreeNode(3);
		s.left.left       = new TreeNode(4);
		s.left.right      = new TreeNode(6);
		s.right.right     = new TreeNode(3);
		s.left.left.right = new TreeNode(30);

		boolean result = containsAsSubTree(s, t);
		System.out.println(result);
	}
	public static boolean containsAsSubTree(TreeNode s, TreeNode t)
	{
		StringBuilder inS = new StringBuilder();
		StringBuilder preS = new StringBuilder();
		StringBuilder inT = new StringBuilder();
		StringBuilder preT = new StringBuilder();

		inOrder(s, inS);
		preOrder(s, preS);
		inOrder(t, inT);
		preOrder(t, preT);

		return ((inS.indexOf(inT.toString()) >= 0) && (preS.indexOf(preT.toString()) >= 0));
	}
	private static void inOrder(TreeNode r, StringBuilder sb)
	{
		if(r == null)
		{
			sb.append("# ");
			return;
		}
		inOrder(r.left, sb);
		sb.append(r.val+" ");
		inOrder(r.right, sb);
	}
	private static void preOrder(TreeNode r, StringBuilder sb)
	{
		if(r == null)
		{
			sb.append("# ");
			return;
		}
		sb.append(r.val+" ");
		preOrder(r.left, sb);
		preOrder(r.right, sb);
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