import java.io.*;
import java.util.*;

public class Day63
{
	static int[] x = {1,0};
	static int[] y = {0,1};
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().split(" ");
		int m = Integer.parseInt(dimString[0]);
		int n = Integer.parseInt(dimString[1]);
		char[][] grid = new char[m][n];
		for(int i=0;i<m;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				grid[i][j] = inpString[j].charAt(0);
			}
		}
		String search = br.readLine();
		br.close();
		boolean result = findInGrid(grid, search);
		System.out.println(result);
	}
	public static boolean findInGrid(char[][] grid, String s)
	{
		if(s.length()>grid.length && s.length()>grid[0].length) return false;
		int m = grid.length;
		int n = grid[0].length;
		int i,j;
		boolean retVal = false;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				retVal = findInGridHelper(grid, s, i, j);
				if(retVal) break;
			}
			if(retVal) break;
		}
		if(retVal) return retVal;
		return false;
	}
	private static boolean findInGridHelper(char[][] g, String s, int i, int j)
	{
		if(s.charAt(0) == g[i][j])
		{
			for(int dir=0;dir<2;dir++)
			{
				int r = i+x[dir];
				int c = j+y[dir];
				int k = 0;
				for(k=1;k<s.length();k++)
				{
					if(!isValid(r,c,g.length,g[0].length)) break;
					if(s.charAt(k) != g[r][c]) break;
					r+=x[dir];
					c+=y[dir];
				}
				if(k == s.length()) return true;
			}
			return false;
		}
		return false;
	}
	private static boolean isValid(int i, int j, int m, int n)
	{
		return ((i>=0 && i<m) && (j>=0 && j<n));
	}
}