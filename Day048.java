import java.io.*;
import java.util.*;

public class Day48
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] preString = br.readLine().split(" ");
		String[] inString = br.readLine().split(" ");
		br.close();
		int[] pre = new int[preString.length];
		int[] in = new int[inString.length];

		for(int i=0;i<preString.length;i++)
		{
			pre[i] = Integer.parseInt(preString[i]);
			in[i] = Integer.parseInt(inString[i]);
		}

		TreeNode root = extractTree(pre, in);
		if(root == null) System.out.println("The root is null!");
		System.out.println("The preorder traversal is -");
		preOrder(root);
		System.out.println("\nThe inorder traversal is -");
		inOrder(root);
	}
	public static TreeNode extractTree(int[] pre, int[] in)
	{
		int[] i = {0};
		return extractTreeHelper(pre,i,in,0,in.length-1);
	}
	private static TreeNode extractTreeHelper(int[] pre, int[] i, int[] in, int lo, int hi)
	{
		if(i[0] == pre.length) return null;
		if(lo>hi) return null;
		if(lo == hi) return new TreeNode(in[lo]);

		TreeNode r = new TreeNode(pre[i[0]]);
		int j;
		for(j=lo;j<=hi;j++)
		{
			if(in[j] == pre[i[0]]) break;
		}
		i[0]++;
		r.left = extractTreeHelper(pre, i, in, lo, j-1);
		i[0]++;
		r.right = extractTreeHelper(pre, i, in, j+1, hi);
		return r;
	}
	private static void preOrder(TreeNode r)
	{
		if(r == null) return;
		System.out.print(r.val+" ");
		preOrder(r.left);
		preOrder(r.right);
	}
	private static void inOrder(TreeNode r)
	{
		if(r == null) return;
		inOrder(r.left);
		System.out.print(r.val+" ");
		inOrder(r.right);
	}
}

class TreeNode
{
	int val;
	TreeNode left, right;
	TreeNode(int x)
	{
		val = x;
		left = null;
		right = null;
	}
}