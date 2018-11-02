import java.io.*;
import java.util.*;

public class Day44
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

		int result = numberOfInversions(arr);
		System.out.println("\n\n"+result);
	}
	public static int numberOfInversions(int[] arr)
	{
		int[] temp = new int[arr.length];
		return mergeSort(arr, temp, 0, arr.length-1);
	}
	public static int mergeSort(int[] arr, int[] temp, int lo, int hi)
	{
		int inv = 0;
		int mid = lo+((hi-lo)/2);

		if(lo>=hi) return inv;
		inv+=mergeSort(arr, temp, lo, mid);
		inv+=mergeSort(arr, temp, mid+1,hi);
		inv+=merge(arr,temp,lo,mid+1,hi);
		return inv;
	}
	public static int merge(int[] arr, int[] temp, int lo, int mid, int hi)
	{
		int inv = 0;
		int i = lo;
		int j = mid;
		int k = lo;
		while(i<mid && j<=hi)
		{
			if(arr[i] <= arr[j])
			{
				temp[k++] = arr[i++];
			}
			else
			{
				temp[k++] = arr[j++];
				inv += (mid-i);
			}
		}
		while(i<mid)
		{
			temp[k++] = arr[i++];
		}
		while(j<=hi)
		{
			temp[k++] = arr[j++];
		}

		for(i=lo;i<=hi;i++)
		{
			arr[i] = temp[i];
		}
		return inv;
	}
}