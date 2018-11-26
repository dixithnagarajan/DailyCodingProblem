import java.io.*;
import java.util.*;

public class Day130
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int k = Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int result = maxProfit(arr, k);
		System.out.println(result);
	}
	public static int maxProfit(int[] a, int k)
	{
		if(a == null || a.length < 2) return -1;
		if(a.length == 2)
		{
			if(k > 1) return -1;
			if(a[1] > a[0]) return a[1]-a[0];
			return 0;
		} 

		int[][] dp = new int[k+1][a.length+1];
		for(int i=0;i<=k;i++)
		{
			dp[i][0] = 0;
		}
		for(int i=0;i<=a.length;i++)
		{
			dp[0][i] = 0;
		}

		for(int i=1;i<=k;i++)
		{
			int prev = Integer.MIN_VALUE;
			for(int j=1;j<a.length;j++)
			{
				prev = Math.max(prev, dp[i-1][j-1]-a[j-1]);
				dp[i][j] = Math.max(dp[i][j-1], a[j]+prev);
			}
		}

		return dp[k][a.length-1];
	}
}