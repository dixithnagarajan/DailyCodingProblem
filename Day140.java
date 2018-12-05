import java.io.*;
import java.util.*;

public class Day140
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

		int[] result = findUnique(arr);
		System.out.println("\n"+result[0]+" "+result[1]);
	}
	public static int[] findUnique(int[] a)
	{
		int xor = 0;
		int x = 0;
		int y = 0;

		for(int i=0;i<a.length;i++)
		{
			xor ^= a[i];
		}

		int set_bit = (xor & ~(xor-1));

		for(int i=0;i<a.length;i++)
		{
			if((a[i]&set_bit) > 0)
			{
				x = x^a[i];
			}
			else y = y^a[i];
		}

		return new int[]{x, y};
	}
}