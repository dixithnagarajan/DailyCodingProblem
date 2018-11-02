import java.io.*;
import java.util.*;

public class Day21
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] input = new int[n][2];
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().split(" ");
			input[i][0] = Integer.parseInt(inpString[0]);
			input[i][1] = Integer.parseInt(inpString[1]);
		}
		br.close();

		int result = numberOfClassRooms(input);
		System.out.println(result);
	}
	public static int numberOfClassRooms(int[][] times)
	{
		int n = times.length;
		int[] arr = new int[n];
		int[] dep = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = times[i][0];
			dep[i] = times[i][1];
		}
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 0;
		int j = 0;
		int ret = 0;
		int maxRet = 1;
		while(i<n && j<n)
		{
			if(arr[i] <= dep[j])
			{
				ret++;
				i++;
				if(ret > maxRet) maxRet = ret;
			}
			else
			{
				ret--;
				j++;
			}
		}
		return maxRet;
	}
}