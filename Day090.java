import java.io.*;
import java.util.*;

public class Day90
{
	static Random r = new Random();
	static boolean notSet = true;
	static int[] map;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] lString = line.split(" ");
		br.close();
		HashSet<Integer> lS = new HashSet<Integer>();
		for(int i=0;i<lString.length;i++)
		{
			int t = Integer.parseInt(lString[i]);
			if(t >= n) continue;
			lS.add(t);
		}
		int[] l = new int[lS.size()];
		int i = 0;
		for(int j: lS)
		{
			l[i] = j;
			i++;
		}
		Arrays.sort(l);

		int result = randomElement(n,lS);
		System.out.println(result);
		result = randomElement(n,l);
		System.out.println(result);
	}
	//O(n) solution
	public static int randomElement(int n, HashSet<Integer> l)
	{
		int t = r.nextInt(n);
		while(l.contains(t))
		{
			t = r.nextInt(n);
		}
		return t;
	}
	//Amortised O(1) solution
	public static int randomElement(int n, int[] l)
	{
		if(notSet)
		{
			map = new int[n-l.length];
			int i=0,j=0;
			int count = 0;
			while(count<n && j<l.length && i<map.length)
			{
				if(count == l[j])
				{
					count++;
					j++;
				}
				else
				{
					map[i] = count;
					i++;
					count++;
				}
			}
			if(j==l.length && i<map.length)
			{
				while(i<map.length)
				{
					map[i] = count;
					count++;
					i++;
				}
			}
			notSet = false;
		}

		int t = r.nextInt(n-l.length);
		return map[t];
	}
}