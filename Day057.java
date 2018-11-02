import java.io.*;
import java.util.*;

public class Day057
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().split(" ");
		int k = Integer.parseInt(br.readLine());
		br.close();
		ArrayList<String> result = minCostWrap(words, k);
		for(String r: result)
		{
			System.out.println(r);
		}
	}
	public static ArrayList<String> minCostWrap(String[] words, int k)
	{
		int curr = 0;
		int cost = 0;

		int[] lenArr = new int[words.length];
		for(int i=0;i<words.length;i++)
		{
			lenArr[i] = words[i].length();
		}
		int[] dp = new int[lenArr.length];
		int[] ans = new int[lenArr.length];

		dp[lenArr.length-1] = 0;
		ans[lenArr.length-1] = lenArr.length-1;

		for(int i=lenArr.length-2;i>=0;i--)
		{
			curr = -1;
			dp[i] = Integer.MAX_VALUE;
			for(int j=i;j<lenArr.length;j++)
			{
				curr+=(lenArr[j]+1);
				if(curr > k) break;
				if(j == lenArr.length-1) cost = 0;
				else
				{
					cost = ((k-curr)*(k-curr))+dp[j+1];
				}

				if(dp[i] > cost)
				{
					dp[i] = cost;
					ans[i] = j;
				}
			}
		}
		int i = 0;
		ArrayList<String> ret = new ArrayList<String>();
		while(i < lenArr.length)
		{
			StringBuilder sb = new StringBuilder(words[i]+(ans[i]==i?"":" "));
			for(int j=i+1;j<=ans[i];j++)
			{
				sb.append(words[j]+(j==ans[i]?"":" "));
			}
			ret.add(sb.toString());
			i = ans[i]+1;
		}
		return ret;
	}
}