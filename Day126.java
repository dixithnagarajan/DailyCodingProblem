import java.io.*;
import java.util.*;

public class Day126
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrString = br.readLine().split(" ");
		int k = Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[arrString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}

		int[] result = rotateArray(arr, k);
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static int[] rotateArray(int[] a, int k)
	{
		if(k <= 0) return a;
		if(a == null || a.length == 1) return a;

		k = k%a.length;
		if(k == 0) return a;

		int temp = 0, j = 0, n = 0;
		for(int i=0;i<gcd(a.length, k);i++)
		{
			temp = a[i];
			j = i;
			while(true)
			{
				n = j+k;
				if(n >= a.length)
				{
					n = n - a.length;
				}
				if(n == i)
				{
					break;
				}
				a[j] = a[n];
				j = n;
			}
			a[j] = temp;
		}

		return a;
	}
	private static int gcd(int a, int b)
	{
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}