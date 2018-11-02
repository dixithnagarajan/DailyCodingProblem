import java.io.*;
import java.util.*;

public class Day87
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, HashSet<String>> north = new HashMap<String, HashSet<String>>();
		HashMap<String, HashSet<String>> east = new HashMap<String, HashSet<String>>();

		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			String[] inp = br.readLine().split(" ");
			String start = inp[0];
			String dir = inp[1];
			String end = inp[2];

			if(dir.equals("N"))
			{
				addInMap(north, end, start);
			}
			else if(dir.equals("E"))
			{
				addInMap(east, end, start);
			}
			else if(dir.equals("W"))
			{
				addInMap(east, start, end);
			}
			else if(dir.equals("S"))
			{
				addInMap(north, start, end);
			}
			else if(dir.equals("NE"))
			{
				addInMap(north, end, start);
				addInMap(east, end, start);
			}
			else if(dir.equals("NW"))
			{
				addInMap(north, end, start);
				addInMap(east, start, end);
			}
			else if(dir.equals("SE"))
			{
				addInMap(north, start, end);
				addInMap(east, end, start);
			}
			else if(dir.equals("SW"))
			{
				addInMap(north, start, end);
				addInMap(east, start, end);
			}
		}
		br.close();
		if(hasCycle(east) || hasCycle(north))
		{
			System.out.println("The rules are invalid");
		}
		else System.out.println("The rules are valid");
	}
	public static boolean hasCycle(HashMap<String,HashSet<String>> map)
	{
		HashMap<String, Boolean> vis = new HashMap<String, Boolean>();
		HashMap<String, Boolean> recStack = new HashMap<String, Boolean>();

		HashSet<String> nodes = new HashSet<String>();
		for(String s: map.keySet())
		{
			nodes.add(s);
		}
		for(HashSet<String> temp: map.values())
		{
			for(String s: temp)
			{
				nodes.add(s);
			}
		}
		HashMap<String,HashSet<String>> graph = new HashMap<String,HashSet<String>>(map);
		for(String s: nodes)
		{
			if(!graph.containsKey(s)) graph.put(s, new HashSet<String>());
		}

		for(String s: nodes)
		{
			vis.put(s, false);
			recStack.put(s, false);
		}
		
		for(String s: nodes)
		{
			if(hasCycleHelper(s, graph, vis, recStack)) return true;
		}
		return false;
	}
	private static boolean hasCycleHelper(String u, HashMap<String,HashSet<String>> g, HashMap<String, Boolean> vi, HashMap<String, Boolean> r)
	{
		if(r.get(u)) return true;
		if(vi.get(u)) return false;
		r.put(u, true);
		vi.put(u, true);
		for(String v: g.get(u))
		{
			if(hasCycleHelper(v, g, vi, r)) return true;
		}
		r.put(u, false);
		return false;
	}
	private static void addInMap(HashMap<String,HashSet<String>> map, String k, String v)
	{
		if(!map.containsKey(k))
		{
			HashSet<String> temp = new HashSet<String>();
			temp.add(v);
			map.put(k, temp);
		}
		else
		{
			HashSet<String> temp = map.get(k);
			temp.add(v);
			map.put(k, temp);
		}
	}
}