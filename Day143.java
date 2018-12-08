import java.io.*;
import java.util.*;

public class Day143
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int k = Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int[] result = partition(arr, k);
		System.out.println();
		for(int i: result)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static int[] partition(int[] a, int k)
	{
		if(a == null || a.length == 1) return a;

		int mid = 0;
		int lo = 0;
		int hi = a.length-1;
		while(mid<=hi)
		{
			if(a[mid] < k)
			{
				int temp = a[mid];
				a[mid] = a[lo];
				a[lo] = temp;
				lo++;
				mid++;
			}
			else if(a[mid] == k) mid++;
			else
			{
				int temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
			}
		}

		return a;
	}
}
