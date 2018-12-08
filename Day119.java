import java.io.*;
import java.util.*;

public class Day119
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arrivals = new int[n];
		int[] departures = new int[n];
		for(int i=0;i<n;i++)
		{
			String[] inputString = br.readLine().split(" ");
			arrivals[i] = Integer.parseInt(inputString[0]);
			departures[i] = Integer.parseInt(inputString[1]);
		}

		ArrayList<Integer> result = stabbingSet(arrivals, departures);
		System.out.println("\n"+result.toString());
	}
	public static ArrayList<Integer> stabbingSet(int[] arr, int[] dep)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		boolean[] visit = new boolean[arr.length];
		Arrays.sort(arr);
		Arrays.sort(dep);
		while(!stillThere(visit))
		{
			int temp = stabbingSet(arr, dep, visit);
			ret.add(temp);
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]<=temp && temp<=dep[i])
				{
					visit[i] = true;
				}
			}
		}
		return ret;
	}
	private static int stabbingSet(int[] arr, int[] dep, boolean[] v)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		for(int i=0;i<v.length;i++)
		{
			if(!v[i])
			{
				a.add(arr[i]);
				d.add(dep[i]);
			}
		}
		int n = a.size();
		int i = 1, j = 0;
		int g=1,maxg=1,time=a.get(0);

		while(i < n && j < n)
		{
			if(a.get(i) <= d.get(j))
			{
				g++;
				if(g > maxg)
				{
					maxg = g;
					time = a.get(i);
				}
				i++;
			}
			else
			{
				g--;
				j++;
			}
		}

		return time;
	}
	private static boolean stillThere(boolean[] a)
	{
		boolean ret = true;
		for(int i=0;i<a.length;i++)
		{
			ret &= a[i];
		}
		return ret;
	}
}
