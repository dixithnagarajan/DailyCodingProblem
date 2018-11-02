import java.io.*;
import java.util.*;

public class Day075
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

		int result = increasingSubArray(arr);
		System.out.println("\n\n"+result);
	}
	public static int increasingSubArray(int[] a)
	{
		int[] tailTable = new int[a.length];
		int len = 1;
		tailTable[0] = a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i] < tailTable[0])
			{
				tailTable[0] = a[i];
			}
			else if(a[i] > tailTable[len - 1])
			{
				tailTable[len] = a[i];
				len++;
			}
			else
			{
				tailTable[ceilSearch(tailTable, -1, len-1, a[i])] = a[i];
			}
		}
		return len;
	}
	private static int ceilSearch(int[] a, int l, int r, int k)
	{
		while((r-l) > 1)
		{
			int m = l+((r-l)/2);
			if(a[m] >= k) r = m;
			else l = m;
		}
		return r;
	}
}