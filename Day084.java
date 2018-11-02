import java.io.*;
import java.util.*;

public class Day84
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sizeString = br.readLine().split(" ");
		int m = Integer.parseInt(sizeString[0]);
		int n = Integer.parseInt(sizeString[1]);

		int[][] grid = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] arrString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				grid[i][j] = Integer.parseInt(arrString[j]);
			}
		}
		br.close();

		System.out.println("\n\nThe grid is -");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		boolean[][] vis = new boolean[m][n];
		int count = 0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if((grid[i][j] == 1) && (!vis[i][j]))
				{
					count += bfs(grid, vis, i, j);
				}
			}
		}
		System.out.println("The number of islands are - "+count);
	}

	public static int bfs(int[][] grid, boolean[][] vis, int i, int j)
	{
		vis[i][j] = true;
		LinkedList<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i,j));
		while(!q.isEmpty())
		{
			Pair p = q.removeFirst();
			int m = grid.length;
			int n = grid[0].length;
			int ii = p.x;
			int jj = p.y;

			if(isValid(ii-1,jj,m,n) && grid[ii-1][jj]==1 && !vis[ii-1][jj])
			{
				vis[ii-1][jj] = true;
				q.add(new Pair(ii-1,jj));
			}
			if(isValid(ii,jj-1,m,n) && grid[ii][jj-1]==1 && !vis[ii][jj-1])
			{
				vis[ii][jj-1] = true;
				q.add(new Pair(ii,jj-1));
			}
			if(isValid(ii,jj+1,m,n) && grid[ii][jj+1]==1 && !vis[ii][jj+1])
			{
				vis[ii][jj+1] = true;
				q.add(new Pair(ii,jj+1));
			}
			if(isValid(ii+1,jj,m,n) && grid[ii+1][jj]==1 && !vis[ii+1][jj])
			{
				vis[ii+1][jj] = true;
				q.add(new Pair(ii+1,jj));
			}
		}
		return 1;
	}

	private static boolean isValid(int i, int j, int m, int n)
	{
		return ((i>=0 && i<m) && (j>=0 && j<n));
	}
}

class Pair
{
	int x,y;
	Pair(int a, int b)
	{
		x = a;
		y = b;
	}
}