import java.io.*;
import java.util.*;

public class Day069
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int result = largestThreeProduct(arr);
		System.out.println("\n"+result);
	}
	public static int largestThreeProduct(int[] arr)
	{
		int maxOne = Integer.MIN_VALUE;
		int maxTwo = Integer.MIN_VALUE;
		int maxThree = Integer.MIN_VALUE;

		int minOne = Integer.MAX_VALUE;
		int minTwo = Integer.MAX_VALUE;

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] > maxOne)
			{
				maxThree = maxTwo;
				maxTwo = maxOne;
				maxOne = arr[i];
			}
			else if(arr[i] > maxTwo)
			{
				maxThree = maxTwo;
				maxTwo = arr[i];
			}
			else if(arr[i] > maxThree) maxThree = arr[i];

			if(arr[i] < minOne)
			{
				minTwo = minOne;
				minOne = arr[i];
			}
			else if(arr[i] < minTwo)
			{
				minTwo = arr[i];
			}
		}
		return Math.max(maxOne*maxTwo*maxThree, minOne*minTwo*maxOne);
	}
}