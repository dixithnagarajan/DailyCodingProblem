import java.io.*;
import java.util.*;

public class Day121
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int k = Integer.parseInt(br.readLine());
		br.close();

		boolean result = canIDoIt(input, k);
		System.out.println("\n"+result);
	}
	public static boolean canIDoIt(String s, int k)
	{
		if(s == null || s.isEmpty()) return true;
		String rev = new StringBuilder(s).reverse().toString();

		int lcs = lcs(s, rev);
		return ((s.length()-lcs) <= k);
	}
	private static int lcs(String s, String srev)
	{
		int[][] dp = new int[s.length()+1][s.length()+1];

		for(int i=1;i<=s.length();i++)
		{
			for(int j=1;j<=s.length();j++)
			{
				if(s.charAt(i-1) == srev.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else
				{
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}

		return dp[s.length()][s.length()];
	}
}