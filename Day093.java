import java.io.*;
import java.util.*;

public class Day93
{
	public static void main(String[] args)
	{
		TreeNode root          = new TreeNode(50);
		root.left              = new TreeNode(30);
		root.right             = new TreeNode(60);
		root.left.left         = new TreeNode(2);
		root.left.right        = new TreeNode(20);
		root.right.left        = new TreeNode(45);
		root.right.right       = new TreeNode(70);
		root.right.right.left  = new TreeNode(65);
		root.right.right.right = new TreeNode(80);

		Info result = findLargestBST(root);
		System.out.println("The maximum size subtree which is BST is - "+result.ans);
		System.out.println("The maximum node is - "+result.t.val);
	}
	public static Info findLargestBST(TreeNode r)
	{
		if(r == null) return new Info(0,0,true,Integer.MAX_VALUE, Integer.MIN_VALUE, null);
		if(r.left==null && r.right==null) return new Info(1,1,true,r.val,r.val,r);
		
		Info l = findLargestBST(r.left);
		Info ri = findLargestBST(r.right);

		Info ret = new Info(1+l.size+ri.size);

		if(l.isBST && ri.isBST && (l.max < r.val) && (ri.min > r.val))
		{
			ret.min = Math.min(l.min, Math.min(r.val, ri.min));
			ret.max = Math.max(ri.max, Math.max(r.val, l.max));

			ret.ans = ret.size;
			ret.isBST = true;
			ret.t = r;
			return ret;
		}

		if(l.ans >= ri.ans)
		{
			ret.t = l.t;
			ret.ans = l.ans;
			ret.isBST = false;
			return ret;
		}
		ret.t = ri.t;
		ret.ans = ri.ans;
		ret.isBST = false;
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

class Info
{
	int size;
	int ans;
	boolean isBST;
	int min;
	int max;
	TreeNode t;

	Info(int a)
	{
		size = a;
	}
	Info(int a, int b, boolean c, int d, int e, TreeNode f)
	{
		size = a;
		ans = b;
		isBST = c;
		min = d;
		max = e;
		t = f;
	}
}