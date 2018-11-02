import java.io.*;
import java.util.*;

public class Day92
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, ArrayList<String>> elist = new TreeMap<String, ArrayList<String>>();

		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			String[] inp = br.readLine().split(" ");
			elist.put(inp[0], new ArrayList<String>());
			for(int j=1;j<inp.length;j++)
			{
				elist.get(inp[0]).add(inp[j]);
			}
		}

		br.close();

		HashMap<String, Boolean> vis = new HashMap<String, Boolean>();
		HashMap<String, Boolean> recStack = new HashMap<String, Boolean>();
		Stack<String> stack = new Stack<String>();
		boolean isNull = false;
		for(String s: elist.keySet())
		{
			vis.put(s,false);
			recStack.put(s,false);
		}
		for(String i: elist.keySet())
		{
			if(dfsUtil(i, vis, recStack, stack, elist))
			{
				isNull = true;
				break;
			}
		}
		if(isNull)
		{
			System.out.println("No such order exists");
		}
		else
		{
			String[] order = new String[stack.size()];
			for(int i=order.length-1;i>=0;i--)
			{
				order[i] = stack.pop();
			}
			System.out.println("\n\n");
			for(int i=0;i<order.length;i++)
			{
				System.out.print(order[i]+" ");
			}
			System.out.println();
		}
	}
	public static boolean dfsUtil(String u, HashMap<String, Boolean> vis, HashMap<String, Boolean> recStack, Stack<String> s, TreeMap<String, ArrayList<String>> el)
	{
		if(recStack.get(u)) return true;
		if(vis.get(u)) return false;
		vis.put(u,true);
		recStack.put(u,true);
		for(String v: el.get(u))
		{
			if(dfsUtil(v, vis, recStack, s, el)) return true;
		}
		recStack.put(u,false);
		s.push(u);
		return false;
	}
}