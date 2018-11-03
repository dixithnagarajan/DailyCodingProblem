import java.io.*;
import java.util.*;

public class Day110
{
	public static void main(String[] args)
	{
		TreeNode root   = new TreeNode(10);
		root.left       = new TreeNode(8);
		root.right      = new TreeNode(2);
		root.right.left = new TreeNode(2);
		root.left.left  = new TreeNode(3);
		root.left.right = new TreeNode(5);

		ArrayList<ArrayList<Integer>> paths = rootToLeafPaths(root);
		System.out.println(paths.toString());
	}
	public static ArrayList<ArrayList<Integer>> rootToLeafPaths(TreeNode r)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		rootToLeafPathsHelper(r, ret, new ArrayList<Integer>());
		return ret;
	}
	private static void rootToLeafPathsHelper(TreeNode node, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp)
	{
		if(node == null) return;
		if((node.left == null) && (node.right == null))
		{
			temp.add(node.val);
			result.add(new ArrayList<Integer>(temp));
			if(temp.size() > 0) temp.remove(temp.size()-1);
			return;
		}
		temp.add(node.val);
		rootToLeafPathsHelper(node.left, result, temp);
		rootToLeafPathsHelper(node.right, result, temp);
		if(temp.size() > 0) temp.remove(temp.size()-1);
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