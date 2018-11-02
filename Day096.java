import java.io.*;
import java.util.*;

public class Day96
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
		ArrayList<int[]> result = permutations(arr);
		for(int i=0;i<result.size();i++)
		{
			int[] temp = result.get(i);
			for(int j: temp)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static ArrayList<int[]> permutations(int[] arr)
	{
		int[] temp = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			temp[i] = arr[i];
		}
		ArrayList<int[]> retVal = new ArrayList<int[]>();
		retVal.add(Arrays.copyOf(temp,temp.length));
		nextPermutation(temp);
		while(!areEqual(temp,arr))
		{
			retVal.add(Arrays.copyOf(temp,temp.length));
			nextPermutation(temp);
		}
		return retVal;
	}
	private static void nextPermutation(int[] a)
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
	private static boolean areEqual(int[] a1, int[] a2)
	{
		if(a1.length != a2.length) return false;
		for(int i=0;i<a1.length;i++)
		{
			if(a1[i] != a2[i]) return false;
		}
		return true;
	}

	private static void print(int[] a)
	{
		System.out.println("In print");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}