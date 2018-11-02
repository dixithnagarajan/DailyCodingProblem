import java.io.*;
import java.util.*;

public class Day4
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arrSingle = br.readLine();
		br.close();
		String[] arrString = arrSingle.split(" ");
		int[] arr = new int[arrString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}
		System.out.println(missingPositive(arr));
	}
	public static int missingPositive(int[] a)
	{
		int i = 0;
		int j = 0;

		for(j=0;j<a.length;j++)
		{
			if(a[j] <= 0)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}

		j = i;
		for(;j<a.length;j++)
		{
			if(((Math.abs(a[j])+i-1) < a.length) && (a[Math.abs(a[j])+i-1] > 0))
			{
				a[Math.abs(a[j])+i-1] *= -1;
			}
		}
		for(int k: a)
		{
			System.out.print(k+" ");
		}
		System.out.println();
		for(j=i;j<a.length;j++)
		{
			if(a[j] > 0) return (j-i+1);
		}
		return a.length-i+1;
	}
}