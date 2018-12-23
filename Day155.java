import java.io.*;
import java.util.*;

public class Day155
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split(" ");
		br.close();
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}
		int result = findMajority(arr);
		System.out.println("\n\n"+result);
	}
	public static int findMajority(int[] arr)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
			else map.put(arr[i],1);
		}
		for(Integer i: map.keySet())
		{
			if(map.get(i) >= arr.length/2) return i;
		}
		return -1;
	}
}
