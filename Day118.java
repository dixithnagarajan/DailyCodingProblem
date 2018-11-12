import java.io.*;
import java.util.*;

public class Day118
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrString = br.readLine().split(" ");
		br.close();
		int[] arr = new int[arrString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}

		int[] result = sortSquared(arr);
		for(int i: result)
		{
			System.out.print(i+" ");
		}
	}
	public static int[] sortSquared(int[] a)
	{
		int[] temp = new int[a.length];
		int ind = 0;
		int k = 0;
		for(k=0;k<a.length;k++)
		{
			if(a[k] >= 0) break;
		}
		int i = k-1;
		int j = k;
		while(i>=0 && j<a.length)
		{
			if(a[i]*a[i] < a[j]*a[j])
			{
				temp[ind] = a[i]*a[i];
				i--;
			}
			else
			{
				temp[ind] = a[j]*a[j];
				j++;
			}
			ind++;
		}
		while(i >= 0)
		{
			temp[ind] = a[i]*a[i];
			i--;
			ind++;
		}
		while(j<a.length)
		{
			temp[ind] = a[j]*a[j];
			j++;
			ind++;
		}

		return temp;
	}
}