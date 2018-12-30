import java.io.*;
import java.util.*;

public class Day165
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split(" ");
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}
		int[] result = minRight(arr);
		for(int i: result)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static int[] minRight(int[] a)
	{
		int[] ret = new int[a.length];
		ret[a.length-1] = 0;

		for(int i=a.length-2;i>=0;i--)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j] < a[i]) ret[i]++;
			}
		}
		return ret;
	}
}
