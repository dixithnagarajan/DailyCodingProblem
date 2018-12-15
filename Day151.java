import java.io.*;
import java.util.*;

public class Day151
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().trim().split(" ");
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
		dimString = br.readLine().trim().split(" ");
		int i = Integer.parseInt(dimString[0]);
		int j = Integer.parseInt(dimString[1]);
		char replace = br.readLine().trim().charAt(0);
		br.close();

		replaceColour(grid, i, j, replace);

		System.out.println("\n\n\n");
		for(int ii=0;ii<m;ii++)
		{
			for(int jj=0;jj<n;jj++)
			{
				System.out.print(grid[ii][jj]+" ");
			}
			System.out.println();
		}
	}
	public static void replaceColour(char[][] g, int i, int j, char c)
	{
		int m = g.length;
		int n = g[0].length;
		char prev = g[i][j];
		LinkedList<Integer> qi = new LinkedList<Integer>();
		LinkedList<Integer> qj = new LinkedList<Integer>();
		boolean[][] vis = new boolean[m][n];
		qi.add(i);
		qj.add(j);
		while(!qi.isEmpty())
		{
			int x = qi.removeFirst();
			int y = qj.removeFirst();

			g[x][y] = c;
			vis[x][y] = true;
			if(isValid(x-1, y, m, n) && !vis[x-1][y] && g[x-1][y]==prev)
			{
				qi.add(x-1);
				qj.add(y);
			}
			if(isValid(x, y-1, m, n) && !vis[x][y-1] && g[x][y-1]==prev)
			{
				qi.add(x);
				qj.add(y-1);
			}
			if(isValid(x, y+1, m, n) && !vis[x][y+1] && g[x][y+1]==prev)
			{
				qi.add(x);
				qj.add(y+1);
			}
			if(isValid(x+1, y, m, n) && !vis[x+1][y] && g[x+1][y]==prev)
			{
				qi.add(x+1);
				qj.add(y);
			}
		}
	}
	private static boolean isValid(int i, int j, int m, int n)
	{
		return ((i>=0 && i<m) && (j>=0 && j<n));
	}
}
