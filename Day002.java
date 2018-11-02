import java.util.*;
import java.io.*;

public class Day2
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

		int[] ret = Arrays.copyOf(arr, arr.length);
		int temp = 1;
		for(int i=0;i<ret.length;i++)
		{
			ret[i] = temp;
			temp *= arr[i];
		}
		temp = 1;
		for(int i=ret.length-1;i>=0;i--)
		{
			ret[i] *= temp;
			temp *= arr[i];
		}
		for(int i=0;i<ret.length;i++)
		{
			System.out.print(ret[i]+" ");
		}
	}
}