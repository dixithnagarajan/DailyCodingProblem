import java.io.*;
import java.util.*;

public class Day12
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("##################################################");
		System.out.println("Please enter N in the first line and\nnumber of allowed steps in the next line");
		System.out.println("##################################################");
		int N = Integer.parseInt(br.readLine());
		String[] allowedString = br.readLine().split(" ");
		int[] allowed = new int[allowedString.length];
		for(int i=0;i<allowed.length;i++)
		{
			allowed[i] = Integer.parseInt(allowedString[i]);
		}
		br.close();
		if(N < 0) System.out.println("Enter Valid Input");
		else if((N == 1) || (N == 0)) System.out.println("1");
		else
		{
			System.out.println(numberOfWays(N, allowed));
		}
	}

	public static int numberOfWays(int N, int[] all)
	{
		long[] dp = new long[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=N;i++)
		{
			for(int j=0;j<all.length;j++)
			{
				if(i-all[j] >= 0) dp[i] += dp[i-all[j]];
			}
		}
		return (int)dp[N];
	}
}