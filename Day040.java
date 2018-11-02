import java.io.*;
import java.util.*;

public class Day40
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

		int result = singleOccurrence(arr);
		System.out.println(result);
	}

	private static int singleOccurrence(int[] arr)
	{
		int mask = 1;
		int ret = 0;
		for(int i=0;i<32;i++)
		{
			mask = (1<<i);
			int sum = 0;
			for(int j=0;j<arr.length;j++)
			{
				sum += ((arr[j]&mask)>>i);
			}
			sum = sum%3;
			ret = ret|(sum<<i);
		}
		return ret;
	}
}