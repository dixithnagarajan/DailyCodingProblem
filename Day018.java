import java.io.*;
import java.util.*;

public class Day18
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrString = br.readLine().split(" ");
		int[] arr = new int[arrString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(arrString[i]);
		}
		int k = Integer.parseInt(br.readLine());
		br.close();
		if(k > arr.length)
		{
			System.out.println("Invalid value for k. Exiting...");
		}
		else if(k == arr.length)
		{
			int max = arr[0];
			for(int i=1;i<arr.length;i++)
			{
				if(arr[i] > max) max = arr[i];
			}
			System.out.println(max);
		}
		else
		{
			int[] result = slidingMax(arr,k);
			for(int i=0;i<result.length;i++)
			{
				System.out.print(result[i]+" ");
			}
		}
	}
	public static int[] slidingMax(int[] arr, int k)
	{
		Deque<Integer> q = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int[] retVal = new int[arr.length-k+1];
		for(;i<k;i++)
		{
			while(!q.isEmpty() && arr[i]>=arr[q.peekLast()]) q.removeLast();
			q.add(i);
		}
		for(;i<arr.length && j<=arr.length-k;i++)
		{
			retVal[j] = arr[q.peekFirst()];
			j++;
			while(!q.isEmpty() && q.peekFirst()<=(i-k)) q.removeFirst();
			while(!q.isEmpty() && arr[i]>=arr[q.peekLast()]) q.removeLast();
			q.add(i);
		}
		retVal[j] = arr[q.peekFirst()];
		return retVal;
	}
}