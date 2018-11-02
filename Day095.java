import java.io.*;
import java.util.*;

public class Day95
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

		nextPermutation(arr);
		for(int i: arr)
		{
			System.out.print(i+" ");
		}
	}
	public static void nextPermutation(int[] a)
	{
		int k,l;
		k = a.length-2;
		while(k>=0)
		{
			if(a[k] >= a[k+1]) k--;
			else break;
		}
		if(k == -1)
		{
			reverseArray(a,0,a.length-1);
		}
		else
		{
			l = a.length-1;
			while(l > k)
			{
				if(a[l] <= a[k]) l--;
				else break;
			}
			int temp = a[l];
			a[l] = a[k];
			a[k] = temp;
			reverseArray(a,k+1,a.length-1);
		}
	}
	private static void reverseArray(int[] a, int start, int end)
	{
		int mid = start+((end-start)/2);
		for(int i=start;i<=mid;i++)
		{
			int temp = a[i];
			a[i] = a[end+start-i];
			a[end+start-i] = temp;
		}
	}
}