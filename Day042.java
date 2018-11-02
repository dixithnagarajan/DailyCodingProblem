import java.io.*;
import java.util.*;

public class Day42
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int[][] dp = new int[arr.length+1][n+1];
		for(int i=0;i<=arr.length;i++)
		{
			for(int j=0;j<=n;j++)
			{
				dp[i][j] = -1;
			}
		}
		if(numOfSolutions(arr,n,0,dp) == 0) System.out.println("[]");
		else
		{
			ArrayList<Integer> result = aSolution(arr,n,dp);
			System.out.println(result.toString());
		}
	}
	public static int numOfSolutions(int[] a, int sum, int i, int[][] dp)
	{
		if(sum < 0) return 0;
		if(i >= a.length)
		{
			if(sum == 0) return 1;
			return 0;
		}
		if(dp[i][sum] == -1)
		{
			int count = numOfSolutions(a,sum,i+1,dp);
			count += numOfSolutions(a,sum-a[i],i+1,dp);
			dp[i][sum] = count;
		}
		return dp[i][sum];
	}
	public static ArrayList<Integer> aSolution(int[] a, int sum, int[][] dp)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
		{
			if(numOfSolutions(a,sum-a[i],i+1,dp) > 0)
			{
				ret.add(a[i]);
				sum -= a[i];
			}
		}
		return ret;
	}
}