import java.io.*;
import java.util.*;

public class Day58
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
		int s = Integer.parseInt(br.readLine());
		br.close();
		int result = shiftedBinarySearch(arr, s, 0, arr.length-1);
		if(result<0) System.out.println("The value doesn't exist in the array!");
		else System.out.println("Value found at index - "+result);
	}
	public static int shiftedBinarySearch(int[] a, int s, int l, int h)
	{
		if(l > h) return -1;
		int mid = l+((h-1)/2);
		if(a[mid] == s) return mid;
		if(a[l] <= a[mid])
		{
			if((s>=a[l]) && (s<=a[mid-1])) return shiftedBinarySearch(a,s,l,mid-1);
			return shiftedBinarySearch(a,s,mid+1,h);
		}
		if((s>=a[mid+1]) && (s<=a[h])) return shiftedBinarySearch(a,s,mid+1,h);
		return shiftedBinarySearch(a,s,l,mid-1);
	}
}