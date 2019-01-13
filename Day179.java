import java.io.*;
import java.util.*;

public class Day179
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split("\\s+");
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}
		System.out.println("\n\n");
		TreeNode result = getTree(arr);
		inOrder(result);
		System.out.println();
		preOrder(result);
		System.out.println();
		postOrder(result);
	}
	public static TreeNode getTree(int[] a)
	{
		return getTree(a, 0, a.length-1);
	}
	private static TreeNode getTree(int[] a, int s, int e)
	{
		if(s > e) return null;
		if(s == e) return new TreeNode(a[s]);
		TreeNode r = new TreeNode(a[e]);
		int curr = a[e];
		int i = 0;
		for(i=e;i>=s;i--)
		{
			if(a[i] < curr) break;
		}
		r.right = getTree(a, i+1, e-1);
		r.left = getTree(a, s, i);
		return r;
	}
	private static void inOrder(TreeNode t)
	{
		if(t == null) return;
		inOrder(t.left);
		System.out.print(t.val+" ");
		inOrder(t.right);
	}
	private static void preOrder(TreeNode t)
	{
		if(t == null) return;
		System.out.print(t.val+" ");
		preOrder(t.left);
		preOrder(t.right);
	}
	private static void postOrder(TreeNode t)
	{
		if(t == null) return;
		postOrder(t.left);
		postOrder(t.right);
		System.out.print(t.val+" ");
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
