import java.io.*;
import java.util.*;

public class Day170
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().trim().split("\\s+");
		String[] inpString = br.readLine().trim().split("\\s+");
		br.close();
		String start = inpString[0];
		String end = inpString[1];
		ArrayList<String> result = transform(start, end, words);
		if(result == null) System.out.println("\n\nnull");
		else System.out.println("\n\n"+result.toString());
	}
	public static ArrayList<String> transform(String s, String e, String[] words)
	{
		if(s.length() != e.length()) return null;
		int N = s.length();
		HashSet<String> w = new HashSet<String>();
		for(String i: words)
		{
			if(i.length() != N) return null;
			w.add(i);
		}
		if(!w.contains(e)) return null;
		if(s.equals(e))
		{
			ArrayList<String> retVal = new ArrayList<String>();
			retVal.add(s);
			return retVal;
		}
		TreeNode root = new TreeNode(s);
		boolean endFound = false;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode ret = null;
		q.add(root);
		q.add(null);
		while(!q.isEmpty() && !endFound)
		{
			TreeNode x = q.remove();
			if(x == null)
			{
				if(!q.isEmpty()) q.add(null);
				continue;
			}
			String str = x.s;
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<26;k++)
				{
					char repChar = (char)('a'+k);
					if(repChar != str.charAt(j))
					{
						StringBuilder sb = new StringBuilder(str);
						sb.setCharAt(j, repChar);
						String sbstr = sb.toString();
						if(w.contains(sbstr))
						{
							TreeNode child = new TreeNode(sbstr, x);
							x.kinder.put(sbstr,child);
							q.add(child);
							if(sb.toString().equals(e))
							{
								endFound = true;
								ret = child;
								break;
							}
						}
					}
				}
				if(endFound) break;
			}
		}
		if(!endFound) return null;
		ArrayList<String> retVal = new ArrayList<String>();
		retVal.add(ret.s);
		ret = ret.p;
		while(ret != null)
		{
			retVal.add(ret.s);
			ret = ret.p;
		}
		Collections.reverse(retVal);
		return retVal;
	}
}

class TreeNode
{
	String s;
	TreeNode p;
	HashMap<String, TreeNode> kinder;
	TreeNode(String s)
	{
		this.s = s;
		this.p = null;
		this.kinder = new HashMap<String, TreeNode>();
	}
	TreeNode(String s, TreeNode t)
	{
		this.s = s;
		this.p = t;
		this.kinder = new HashMap<String, TreeNode>();
	}
}
