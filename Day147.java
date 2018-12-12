import java.io.*;
import java.util.*;

public class Day147
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		br.close();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<inpString.length;i++)
		{
			lst.add(Integer.parseInt(inpString[i]));
		}
		ArrayList<Integer> result = sort(lst);
		for(int i: result)
		{
			System.out.print(i+" ");
		}
	}
	public static ArrayList<Integer> sort(ArrayList<Integer> l)
	{
		int n = l.size();
		for(int i=n-1;i>=0;i--)
		{
			int maxInd = maxIndex(l, 0, i);
			reverse(l, maxInd, i);
		}
		return l;
	}
	public static int maxIndex(ArrayList<Integer> l, int start, int end)
	{
		if(start == end) return start;
		int max = l.get(start);
		int max_ind = start;
		for(int i=start;i<=end;i++)
		{
			if(l.get(i) > max)
			{
				max = l.get(i);
				max_ind = i;
			}
		}
		return max_ind;
	}
	public static void reverse(ArrayList<Integer> l, int start, int end)
	{
		if(start == end) return;
		int mid = (start+end)/2;
		for(int i=start;i<=mid;i++)
		{
			int temp = l.get(i);
			l.set(i, l.get(end+start-i));
			l.set(end+start-i, temp);
		}
	}
}
