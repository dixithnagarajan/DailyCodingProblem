import java.io.*;
import java.util.*;

public class Day41
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] tickets = new String[n][2];
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().split(" ");
			tickets[i][0] = inpString[0];
			tickets[i][1] = inpString[1];
		}
		String start = br.readLine();
		br.close();
		ArrayList<String> itinerary = flightItinerary(tickets, start);
		if(itinerary == null) System.out.println("No such itinerary exists!");
		else System.out.println(itinerary.toString());
	}
	public static ArrayList<String> flightItinerary(String[][] t, String s)
	{
		HashSet<String> nodes = new HashSet<String>();
		HashMap<String, TreeSet<String>> edges = new HashMap<String, TreeSet<String>>();

		for(int i=0;i<t.length;i++)
		{
			if(!nodes.contains(t[i][0])) nodes.add(t[i][0]);
			if(!nodes.contains(t[i][1])) nodes.add(t[i][1]);

			if(!edges.containsKey(t[i][0]))
			{
				TreeSet<String> temp = new TreeSet<String>();
				temp.add(t[i][1]);
				edges.put(t[i][0], temp);
			}
			else
			{
				TreeSet<String> temp = edges.get(t[i][0]);
				temp.add(t[i][1]);
				edges.put(t[i][0], temp);
			}
		}
		HashMap<String, Boolean> vis = new HashMap<String, Boolean>();
		for(String st: nodes)
		{
			vis.put(st, false);
		}
		
		ArrayList<String> ret = new ArrayList<String>();
		LinkedList<String> q = new LinkedList<String>();
		q.add(s);
		while(!q.isEmpty())
		{
			String u = q.removeFirst();
			vis.put(u,true);
			ret.add(u);
			String v = (edges.containsKey(u))?((edges.get(u).isEmpty())?null:edges.get(u).pollFirst()):null;
			if(v!=null) q.add(v);
		}
		for(String st: vis.keySet())
		{
			if(!vis.get(st)) return null;
		}
		return ret;
	}
}