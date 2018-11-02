import java.io.*;
import java.util.*;

public class Day106
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
		boolean result = canDo(arr);
		System.out.println("\n"+result);
	}
	public static boolean canDo(int[] arr)
	{
		int i = 0;
		while(i>=0 && i<arr.length)
		{
			if(arr[i] == 0) break;
			i += arr[i];
		}
		return (i == arr.length-1);
	}
}