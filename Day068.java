import java.io.*;
import java.util.*;

public class Day68
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		Pair[] locs = new Pair[N];
		for(int i=0;i<N;i++)
		{
			String[] inpString = br.readLine().split(" ");
			locs[i] = new Pair(Integer.parseInt(inpString[0]), Integer.parseInt(inpString[1]));
		}
		br.close();
		int result = numberOfKills(locs,M);
		System.out.println("Number of pairs which are under attack are - "+result);
	}
	public static int numberOfKills(Pair[] locs, int m)
	{
		int[] add = new int[2*m];
		int[] sub = new int[2*m];
		for(int i=0;i<locs.length;i++)
		{
			add[locs[i].x+locs[i].y]++;
			if(locs[i].x >= locs[i].y) sub[locs[i].x-locs[i].y]++;
			else sub[m+locs[i].y-locs[i].x]++;
		}
		int retVal = 0;
		for(int i=0;i<m;i++)
		{
			if(add[i] > 1) retVal+=((add[i]*(add[i]-1))/2);
			if(sub[i] > 1) retVal+=((sub[i]*(sub[i]-1))/2);
		}
		return retVal;
	}
}

class Pair
{
	int x, y;
	Pair(int a, int b)
	{
		x = a;
		y = b;
	}
}