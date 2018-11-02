import java.io.*;
import java.util.*;

public class Day102
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int K = Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int[] result = subarraySum(arr, K);
		System.out.println(result[0]+" "+result[1]);
		System.out.println("\nThe subarray is -");
		for(int i=result[0];i<=result[1];i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static int[] subarraySum(int[] arr, int K)
	{
		int sum = 0;
		int start = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			if(sum == K) return new int[]{0,i};
			if(map.containsKey(sum-K))
			{
				return new int[]{map.get(sum-K)+1, i};
			}
			map.put(sum,i);
		}
		return new int[]{-1,-1};
	}
}