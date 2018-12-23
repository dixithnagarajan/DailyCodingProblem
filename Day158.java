import java.io.*;
import java.util.*;

public class Day158
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().trim().split(" ");
		int m = Integer.parseInt(dimString[0]);
		int n = Integer.parseInt(dimString[1]);
		int[][] grid = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				grid[i][j] = inpString[j].charAt(0)-'0';
			}
		}
		br.close();
		int result = topToBottom(grid);
		System.out.println("\n\n"+result);
	}
	public static int topToBottom(int[][] g)
	{
		int[] ret = new int[1];
		topToBottomHelper(g, 0, 0, ret);
		return ret[0];
	}
	private static void topToBottomHelper(int[][] g, int i, int j, int[] ret)
	{
		if(i == g.length-1 && j == g[0].length-1)
		{
			ret[0]++;
			return;
		}
		if(isValid(i, j+1, g.length, g[0].length) && (g[i][j+1] == 0)) topToBottomHelper(g, i, j+1, ret);
		if(isValid(i+1, j, g.length, g[0].length) && (g[i+1][j] == 0)) topToBottomHelper(g, i+1, j, ret);
	}
	private static boolean isValid(int i, int j, int m, int n)
	{
		return ((i>=0 && i<m) && (j>=0 && j<n));
	}
}
