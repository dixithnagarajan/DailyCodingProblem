import java.io.*;
import java.util.*;

public class Day30
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrString = br.readLine().split(" ");
		int[] arr = new int[arrString.length];
		br.close();
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}

		int left_max = 0;
		int right_max = 0;
		int result = 0;

		int l = 0;
		int r = arr.length-1;
		while(l <= r)
		{
			if(arr[l] < arr[r])
			{
				if(arr[l] > left_max) left_max = arr[l];
				else result+=(left_max-arr[l]);
				l++;
			}
			else
			{
				if(arr[r] > right_max) right_max = arr[r];
				else result+=(right_max-arr[r]);
				r--;
			}
		}

		System.out.println(result);
	}
}