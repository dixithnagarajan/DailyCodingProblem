import java.io.*;
import java.util.*;

public class Day149
{
	private static HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split(" ");
		String[] sString = br.readLine().trim().split(" ");
		br.close();
		int start = Integer.parseInt(sString[0]);
		int end = Integer.parseInt(sString[1]);
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int sum = seqSum(arr, start, end);
		System.out.println("\n"+sum);
		preprocess(arr);
		sum = preSum(arr, start, end);
		System.out.println("\n"+sum);
	}
	public static int seqSum(int[] a, int i, int j)
	{
		if(i >= j) return -1;
		if(a == null || a.length == 0) return -1;
		if(i >= a.length || j > a.length) return -1;
		if(i<0 || j<=0) return -1;

		if(j == i+1) return a[i];
		int sum = 0;
		for(int ii=i;ii<j;ii++)
		{
			sum+=a[ii];
		}
		return sum;
	}
	public static void preprocess(int[] a)
	{
		if(a == null || a.length == 0) return;
		for(int i=0;i<a.length;i++)
		{
			HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
			temp.put(i+1, a[i]);
			map.put(i, temp);
		}
		for(int i=0;i<a.length;i++)
		{
			int sum = a[i];
			for(int j=i+1;j<a.length;j++)
			{
				sum+=a[j];
				HashMap<Integer, Integer> temp = map.get(i);
				temp.put(j+1, sum);
				map.put(i, temp);
			}
		}
	}
	public static int preSum(int[] a, int i, int j)
	{
		if(map.size() == 0) return -1;
		if(i >= j) return -1;
		if(i >= a.length || j > a.length) return -1;
		if(i<0 || j<=0) return -1;

		return map.get(i).get(j);
	}
}
