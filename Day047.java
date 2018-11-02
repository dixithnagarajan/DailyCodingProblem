import java.io.*;
import java.util.*;

public class Day47
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int result = findStock(arr);
		System.out.println("\n\n"+result);
	}
	public static int findStock(int[] arr)
	{
		int i = 0;
		int max = 0;
		int n = arr.length;
		while(i<(n-1))
		{
			while(i<(n-1) && arr[i+1]<=arr[i])
			{
				i++;
			}
			if(i == n-1) break;
			int b = i++;
			while(i<n && arr[i]>=arr[i-1])
			{
				i++;
			}
			int s = i-1;
			if(arr[s]-arr[b] > max) max = (arr[s]-arr[b]);
		}
		return max;
	}
}