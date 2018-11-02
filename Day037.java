import java.io.*;
import java.util.*;

public class Day37
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

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<=((1<<arr.length)-1);i++)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=0;j<arr.length;j++)
			{
				if((i&(1<<j)) != 0) temp.add(arr[j]);
			}
			result.add(temp);
		}

		System.out.println("\n{");
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i).toString()+",");
		}
		System.out.println("}");
	}
}