import java.io.*;
import java.util.*;

public class Day1
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
		int sum = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>();
		boolean found = false;
		for(int i=0;i<arr.length;i++)
		{
			if(hs.contains(arr[i]))
			{
				found = true;
				System.out.println("Yes, "+(sum-arr[i])+" and "+arr[i]+" make the pair");
			}
			else hs.add(sum-arr[i]);
		}
		if(!found) System.out.println("No, so such pair exist!");
	}
}