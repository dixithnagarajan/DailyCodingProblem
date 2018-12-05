import java.io.*;
import java.util.*;

public class Day136
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().split(" ");
		int m = Integer.parseInt(dimString[0]);
		int n = Integer.parseInt(dimString[1]);

		int[][] input = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				input[i][j] = Integer.parseInt(inpString[j]);
			}
		}

		int area = maxArea(input);
		System.out.println("\n"+area);
	}
	public static int maxArea(int[][] a)
	{
		int result = maxHist(a[0]);
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j] == 1) a[i][j] += a[i-1][j];
			}
			result = Math.max(result, maxHist(a[i]));
		}

		return result;
	}
	private static int maxHist(int[] a)
	{
		Stack<Integer> s = new Stack<Integer>();
		int area = 0;
		int max_area = 0;
		int i = 0;
		while(i < a.length)
		{
			if(s.isEmpty() || a[s.peek()] <= a[i])
			{
				s.push(i++);
			}
			else
			{
				int top = a[s.pop()];
				area = top*i;
				if(!s.isEmpty())
				{
					area = top*(i-s.peek()-1);
				}
				max_area = Math.max(area, max_area);
			}
		}

		while(!s.isEmpty())
		{
			int top = a[s.pop()];
			area = top*i;
			if(!s.isEmpty())
			{
				area = top*(i-s.peek()-1);
			}
			max_area = Math.max(area, max_area);
		}

		return max_area;
	}
}