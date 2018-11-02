import java.io.*;
import java.util.*;

public class Day50
{
	public static void main(String[] args) throws IOException
	{
		TreeNode root    = new TreeNode('*');
		root.left        = new TreeNode('+');
		root.right       = new TreeNode('+');
		root.left.left   = new TreeNode('3');
		root.left.right  = new TreeNode('2');
		root.right.left  = new TreeNode('4');
		root.right.right = new TreeNode('5');

		int result = evaluate(root);
		System.out.println(result);
	}
	public static int evaluate(TreeNode r)
	{
		if(r == null) return 0;
		if((r.left == null) && (r.right == null)) return r.val-'0';
		int left = evaluate(r.left);
		int right = evaluate(r.right);

		char c = r.val;
		if(c == '+') return left+right;
		if(c == '-') return left-right;
		if(c == '*') return left*right;
		return left/right;
	}
}

class TreeNode
{
	char val;
	TreeNode left, right;
	TreeNode(char c)
	{
		val = c;
		left = null;
		right = null;
	}
}