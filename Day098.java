import java.io.*;
import java.util.*;

public class Day98
{
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

		boolean result = isPresent(grid, search);
		if(result) System.out.println("Yes, it is present");
		else System.out.println("No, it is not present");
	}
	public static boolean isPresent(char[][] grid, String s)
	{
		char c = s.charAt(0);
		int m = grid.length;
		int n = grid[0].length;
		boolean retVal = false;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j] == c)
				{
					if(isPresentHelper(grid,s,0,i,j))
					{
						retVal = true;
						break;
					}
				}
			}
			if(retVal) break;
		}
		return retVal;
	}
	private static boolean isPresentHelper(char[][] g, String s, int p, int r, int c)
	{
		if(!isValid(r,c,g.length,g[0].length)) return false;
		if(g[r][c] == s.charAt(p))
		{
			if(p == s.length()-1) return true;
			g[r][c] = '#';
			return isPresentHelper(g,s,p+1,r-1,c)||isPresentHelper(g,s,p+1,r,c-1)||isPresentHelper(g,s,p+1,r,c+1)||isPresentHelper(g,s,p+1,r+1,c);
		}
		return false;
	}
	private static boolean isValid(int i, int j, int m, int n)
	{
		return ((i>=0 && i<m) && (j>=0 && j<n));
	}
}