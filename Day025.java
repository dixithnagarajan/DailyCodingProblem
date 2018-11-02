import java.io.*;
import java.util.*;

public class Day25
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String regex = br.readLine();
		String s = br.readLine();
		br.close();
		if(isMatching(s, regex)) System.out.println("Yes, the regex matches the string");
		else System.out.println("No, the regex doesn't match the string");
	}
	public static boolean isMatching(String s, String regex)
	{
		boolean[][] dp = new boolean[s.length()+1][regex.length()+1];
		dp[0][0] = true;

		for(int i=1;i<=regex.length();i++)
		{
			if(regex.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];	
		}

		for(int i=1;i<=s.length();i++)
		{
			for(int j=1;j<=regex.length();j++)
			{
				if(regex.charAt(j-1) == '*')
				{
					dp[i][j] = dp[i][j-1]||dp[i-1][j];
				}
				else if((regex.charAt(j-1) == '.') || (s.charAt(i-1) == regex.charAt(j-1)))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else dp[i][j] = false;
			}
		}
		return dp[s.length()][regex.length()];
	}
}