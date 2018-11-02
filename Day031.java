import java.io.*;
import java.util.*;

public class Day31
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		br.close();

		int result = editDistance(s1, s2);
		System.out.println("The edit distance is - "+result);
	}
	public static int editDistance(String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m+1][n+1];
		dp[0][0] = 0;
		for(int i=1;i<=n;i++)
		{
			dp[0][i] = i;
		}
		for(int i=1;i<=m;i++)
		{
			dp[i][0] = i;
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
				else dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
			}
		}
		return dp[m][n];
	}
}