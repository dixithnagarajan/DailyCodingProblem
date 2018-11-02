import java.io.*;
import java.util.*;

public class Day3
{
	static TreeNode r = null;

	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		TreeNode root         = new TreeNode(20);
		root.left             = new TreeNode(8);
		root.right            = new TreeNode(22);
		root.left.left        = new TreeNode(4);
		root.left.right       = new TreeNode(12);
		root.left.right.left  = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		String s = serialise(root);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fw = new FileWriter(br.readLine());
		fw.write(s);
		fw.close();

		BufferedReader b = new BufferedReader(new FileReader(br.readLine()));
		s = b.readLine();
		b.close();
		br.close();
		TreeNode root1 = deserialise(s);
		if(equals(root, root1)) System.out.println("Yes, both the trees are same.");
		else System.out.println("No, both the trees are different");
	}

	public static String serialise(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		return sb.toString();
	}
	public static TreeNode deserialise(String s)
	{
		s = s.trim().replaceAll("( )+"," ");
		String[] st = s.split(" ");
		int[] i = new int[1];
		i[0] = 0;
		TreeNode r = null;
		r = deserialiseHelper(r, st, i);
		return r;
	}
	private static TreeNode deserialiseHelper(TreeNode r, String[] s, int[] i)
	{
		if(i[0] >= s.length) return null;
		if(s[i[0]].equals("-1")) return null;
		r = new TreeNode(Integer.parseInt(s[i[0]]));
		i[0]++;
		r.left = deserialiseHelper(r.left, s, i);
		i[0]++;
		r.right = deserialiseHelper(r.right, s, i);
		return r;
	}
	private static boolean equals(TreeNode t1, TreeNode t2)
	{
		if((t1 == null) && (t2 == null)) return true;
		if((t1 == null) || (t2 == null)) return false;
		return ( (t1.val == t2.val) && (equals(t1.left, t2.left)) && (equals(t1.right, t2.right)) );
	}
	private static void preOrder(TreeNode n, StringBuilder sb)
	{
		if(n == null)
		{
			sb.append("-1 ");
			return;
		}
		sb.append(n.val+" ");
		preOrder(n.left, sb);
		preOrder(n.right, sb);
	}

	private static void inOrder(TreeNode t)
	{
		if(t == null) return;
		inOrder(t.left);
		System.out.print(t.val+" ");
		inOrder(t.right);
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int c)
	{
		val = c;
		left = null;
		right = null;
	}
}