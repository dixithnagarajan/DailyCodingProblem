import java.io.*;
import java.util.*;

public class Day164
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		br.close();
		int[] arr = new int[n+1];
		makeArray(arr);
		int result = findDuplicate(arr);
		for(int i=0;i<=n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n\n");
		System.out.println(result);
	}
	public static int findDuplicate(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int x = Math.abs(a[i]);
			if(a[x-1] > 0) a[x-1] *= -1;
			else return x;
		}
		return -1;
	}
	public static void makeArray(int[] arr)
	{
		Random r = new Random();
		int n = arr.length - 1;
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = r.nextInt(n) + 1;
		}
	}
}
