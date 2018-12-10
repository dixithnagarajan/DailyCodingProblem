import java.io.*;
import java.util.*;

public class Day144
{
	private static int[] nextArr;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrString = br.readLine().split(" ");
		int ind = Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[arrString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}

		int result = nearestGreatest(arr, ind);
		System.out.println("\n"+result);
		preprocess(arr);
		result = nearestGreatestPreProcess(ind);
		System.out.println(result);
	}
	public static int nearestGreatest(int[] a, int i)
	{
		int j=i+1,k=i-1;
		while(k >= 0)
		{
			if(a[k] <= a[i]) k--;
			else break;
		}
		while(j<a.length)
		{
			if(a[j] <= a[i]) j++;
			else break;
		}
		if(j == a.length && k == -1) return -1;
		if(j == a.length) return k;
		if(k == -1) return j;
		if(Math.abs(i-j) <= Math.abs(i-k)) return j;
		return k;
	}
	public static void preprocess(int[] a)
	{
		nextArr = new int[a.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=a.length-1;i>=0;i--)
		{
			while(!s.isEmpty() && a[s.peek()]<=a[i])
			{
				s.pop();
			}
			nextArr[i] = s.isEmpty()?-1:s.peek();
			s.push(i);
		}

		while(!s.isEmpty())
		{
			s.pop();
		}
		s.push(0);
		for(int i=1;i<nextArr.length;i++)
		{
			while(!s.isEmpty() && a[s.peek()]<=a[i])
			{
				s.pop();
			}
			int repVal = s.isEmpty()?-1:s.peek();
			s.push(i);
			if(repVal >= 0)
			{
				if(nextArr[i] == -1) nextArr[i] = repVal;
				else if(Math.abs(i-repVal) < Math.abs(i-nextArr[i])) nextArr[i] = repVal;
			}
		}
	}
	public static int nearestGreatestPreProcess(int i)
	{
		return nextArr[i];
	}
}
