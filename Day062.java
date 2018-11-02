import java.io.*;
import java.util.*;

public class Day62
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		br.close();
		int result = numOfWays(n,m);
		System.out.println("Number of ways are - "+result);
	}
	public static int numOfWays(int n, int m)
	{
		int[][] dp = new int[n][m];
		dp[0][0] = 0;
		for(int i=0;i<n;i++)
		{
			dp[i][0] = 1;
		}
		for(int i=0;i<m;i++)
		{
			dp[0][i] = 1;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[n-1][m-1];
	}
}