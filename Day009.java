import java.io.*;
import java.util.*;

public class Day9
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrString = br.readLine().split(" ");
		br.close();
		int[] arr = new int[arrString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}

		long[] dp =new long[arr.length+1];
		dp[0] = 0;
		dp[1] = arr[0];
		for(int i=2;i<=arr.length;i++)
		{
			dp[i] = Math.max(dp[i-1], arr[i-1]+dp[i-2]);
		}
		System.out.println("The maximum sum of non-adjacent numbers is - "+dp[arr.length]);
	}
}