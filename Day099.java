import java.io.*;
import java.util.*;

public class Day99
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

		int result = findConsecutive(arr);
		System.out.println(result);
	}
	public static int findConsecutive(int[] a)
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		int max = 0;
		for(int i: a)
		{
			hs.add(i);
		}
		for(int i=0;i<a.length;i++)
		{
			if(!hs.contains(a[i]-1))
			{
				int j = a[i];
				while(hs.contains(j))
				{
					j++;
				}
				int curr = j-a[i];
				if(curr > max) max = curr;
			}
		}
		return max;
	}
}