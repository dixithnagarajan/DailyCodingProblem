import java.io.*;
import java.util.*;

public class Day156
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		br.close();
		int result = minSquares(n);
		System.out.println("\n\n"+result);
	}
	public static int minSquares(int n)
	{
		if(n == 1) return 1;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4;i<=n;i++)
		{
			dp[i] = i;
			for(int x=1;x<=i;x++)
			{
				int temp = x*x;
				if(temp > i) break;
				else dp[i] = Math.min(dp[i], 1+dp[i-temp]);
			}
		}
		return dp[n];
	}
}
