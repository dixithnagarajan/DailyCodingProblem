import java.io.*;
import java.util.*;

public class Day060
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}
		boolean result = canDo(arr);
		System.out.println("\n"+result);
	}
	public static boolean canDo(int[] arr)
	{
		int n = 0;
		for(int i=0;i<arr.length;i++)
		{
			n+=arr[i];
		}
		if((n&1) == 1) return false;

		boolean[][] dp = new boolean[n/2+1][arr.length+1];

		for(int i=0;i<=arr.length;i++)
		{
			dp[0][i] = true;
		}
		for(int i=1;i<dp.length;i++)
		{
			dp[i][0] = false;
		}

		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<=arr.length;j++)
			{
				dp[i][j] = dp[i][j-1];
				if(i>=arr[j-1]) dp[i][j] = dp[i][j] || dp[i-arr[j-1]][j];
			}
		}

		return dp[n/2][arr.length];
	}
}