import java.io.*;
import java.util.*;

public class Day125
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(15);
		int K = 20;

		ArrayList<Integer> result = findSum(root, K);
		System.out.println(result.toString());
	}
	public static ArrayList<Integer> findSum(TreeNode root, int K)
	{
		HashSet<Integer> map = new HashSet<Integer>();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		findSum(root, K, map, ret);
		return ret;
	}
	private static void findSum(TreeNode r, int K, HashSet<Integer> hs, ArrayList<Integer> ret)
	{
		if(r == null) return;
		findSum(r.left, K, hs, ret);
		if(hs.contains(K-r.val))
		{
			ret.add(K-r.val);
			ret.add(r.val);
		}
		hs.add(r.val);
		findSum(r.right, K, hs, ret);
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