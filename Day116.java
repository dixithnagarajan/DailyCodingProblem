import java.io.*;
import java.util.*;

public class Day116
{
	Random rNode;
	Random rChance;

	public Day116()
	{
		rNode = new Random();
		rChance = new Random();
	}

	public TreeNode generateTree()
	{
		TreeNode _r = new TreeNode(rNode.nextInt());

		if(rChance.nextFloat() < 0.5)
		{
			_r.left = generateTree();
		}
		if(rChance.nextFloat() < 0.5)
		{
			_r.right = generateTree();
		}

		return _r;
	}

	public void inOrder(TreeNode r)
	{
		if(r == null)
		{
			System.out.print("null ");
			return;
		}
		inOrder(r.left);
		System.out.print(r.val+" ");
		inOrder(r.right);
	}
	public void preOrder(TreeNode r)
	{
		if(r == null)
		{
			System.out.print("null ");
			return;
		}
		System.out.print(r.val+" ");
		preOrder(r.left);
		preOrder(r.right);
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