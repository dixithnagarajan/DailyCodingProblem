import java.io.*;
import java.util.*;

public class Day72
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nodes = br.readLine();
		boolean hasSelfEdge = false;
		int n = nodes.length();
		int m = Integer.parseInt(br.readLine());
		ArrayList<int[]> edges = new ArrayList<int[]>();
		for(int i=0;i<m;i++)
		{
			String[] inpString = br.readLine().split(" ");
			if(inpString[0].equals(inpString[1])) hasSelfEdge = true;
			edges.add(new int[]{Integer.parseInt(inpString[0]),Integer.parseInt(inpString[1])});
		}
		br.close();
		ArrayList<HashSet<Integer>> elist = new ArrayList<HashSet<Integer>>();
		for(int i=0;i<n;i++)
		{
			elist.add(new HashSet<Integer>());
		}
		for(int i=0;i<m;i++)
		{
			int[] edge = edges.get(i);
			elist.get(edge[0]).add(edge[1]);
		}
		boolean hasCycle = false;
		StringBuilder[] maxString = new StringBuilder[1];
		maxString[0] = new StringBuilder();
		if(hasSelfEdge)
		{
			System.out.println("Has self-edges. So, the value is infinity.");
		}
		else
		{
			boolean[] vis = new boolean[n];
			boolean[] recStack = new boolean[n];
			for(int i=0;i<n;i++)
			{
				if(dfsUtil(i, nodes, vis, recStack, elist, new StringBuilder(), maxString))
				{
					System.out.println("Has cycles. So, the value is infinity.");
					hasCycle = true;
					break;
				}
			}
			if(!hasCycle)
			{
				System.out.println("The maximum path string is - "+maxString[0].toString());
				System.out.println("The maximum path value is - "+maxFreq(maxString[0].toString()));
			}
		}
	}
	public static boolean dfsUtil(int u, String nodes, boolean[] vis, boolean[] recStack, ArrayList<HashSet<Integer>> el, StringBuilder curr_res,
														 StringBuilder[] max)
	{
		if(recStack[u]) return true;
		if(vis[u]) return false;
		vis[u] = true;
		recStack[u] = true;
		curr_res.append(nodes.charAt(u));
		for(int v: el.get(u))
		{
			if(dfsUtil(v,nodes,vis,recStack,el,curr_res,max))
			{
				curr_res.deleteCharAt(curr_res.length()-1);
				return true;
			}
		}
		recStack[u] = false;
		int curr_freq = maxFreq(curr_res.toString());
		int max_freq = maxFreq(max[0].toString());
		if(curr_freq > max_freq)
		{
			max[0] = new StringBuilder(curr_res.toString());
		}
		if(curr_res.length() > 0) curr_res.deleteCharAt(curr_res.length()-1);
		return false;
	}
	private static int maxFreq(String s)
	{
		int[] freq = new int[26];
		for(int i=0;i<s.length();i++)
		{
			freq[s.charAt(i)-'A']++;
		}
		int max = freq[0];
		for(int i=1;i<26;i++)
		{
			if(freq[i] > max) max = freq[i];
		}
		return max;
	}
}