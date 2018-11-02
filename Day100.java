import java.io.*;
import java.util.*;

public class Day100
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] points = new int[n][2];
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().split(" ");
			points[i][0] = Integer.parseInt(inpString[0]);
			points[i][1] = Integer.parseInt(inpString[1]);
		}
		br.close();
		int result = minSteps(points);
		System.out.println("\n"+result);
	}
	public static int minSteps(int[][] locs)
	{
		int ret = 0;
		for(int i=0;i<(locs.length-1);i++)
		{
			ret += distanceBetween(new int[]{locs[i][0],locs[i][1]}, new int[]{locs[i+1][0], locs[i+1][1]});
		}
		return ret;
	}
	private static int distanceBetween(int[] a, int[] b)
	{
		if((a[0] == b[0]) && (a[1] == b[1])) return 0;
		if(a[0] == b[0]) return Math.abs(a[1]-b[1]);
		if(a[1] == b[1]) return Math.abs(a[0]-b[0]);
		if(Math.abs(a[0]-a[1]) == Math.abs(b[0]-b[1]))
		{
			return (Math.abs((b[0]+b[1])-(a[0]+a[1]))/2);
		}
		if((a[0]+a[1]) == (b[0]+b[1]))
		{
			return (Math.abs((b[1]-b[0])-(a[1]-a[0]))/2);
		}

		return Math.max(Math.abs(a[0]-b[0]), Math.abs(a[1]-b[1]));
	}

}