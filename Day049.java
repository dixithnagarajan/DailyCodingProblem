import java.io.*;
import java.util.*;

public class Day49
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}

		int curr_max = 0;
		int max = 0;

		for(int i=0;i<arr.length;i++)
		{
			curr_max = curr_max+arr[i];
			if(curr_max > max)
			{
				max = curr_max;
			}
			if(curr_max < 0) curr_max = 0;
		}
		System.out.println(max);
	}
}