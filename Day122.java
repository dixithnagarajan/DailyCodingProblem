import java.io.*;
import java.util.*;

public class Day122
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().split(" ");
		int m = Integer.parseInt(dimString[0]);
		int n = Integer.parseInt(dimString[1]);

		int[][] mat = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] rowString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				mat[i][j] = Integer.parseInt(rowString[j]);
			}
		}
		br.close();
		int result = maxCoins(mat);
		System.out.println("\n\n"+result);
	}
	public static int maxCoins(int[][] m)
	{
		int[][] dp = new int[m.length][m[0].length];
		dp[0][0] = m[0][0];
		for(int i=1;i<m.length;i++)
		{
			dp[i][0] = dp[i-1][0]+m[i][0];
		}
		for(int j=1;j<m[0].length;j++)
		{
			dp[0][j] = dp[0][j-1]+m[0][j];
		}

		for(int i=1;i<m.length;i++)
		{
			for(int j=1;j<m[0].length;j++)
			{
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		}

		return dp[m.length-1][m[0].length-1];
	}
}