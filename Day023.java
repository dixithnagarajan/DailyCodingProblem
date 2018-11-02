import java.io.*;
import java.util.*;

public class Day23
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().split(" ");
		int m = Integer.parseInt(dimString[0]);
		int n = Integer.parseInt(dimString[1]);
		int[][] grid = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				if(inpString[j].equals("t")) grid[i][j] = 0;
				else if(inpString[j].equals("f")) grid[i][j] = 1;
			}
		}
		String[] startString = br.readLine().split(" ");
		int si = Integer.parseInt(startString[0]);
		int sj = Integer.parseInt(startString[1]);
		String[] endString = br.readLine().split(" ");
		int ei = Integer.parseInt(endString[0]);
		int ej = Integer.parseInt(endString[1]);
		System.out.println("The given grid is - ");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("We are starting at - ("+si+" , "+sj+")");
		System.out.println("We are ending at - ("+ei+" , "+ej+")");

		int result = bfs(grid, si, sj, ei, ej);
		System.out.println("\n\nThe minimum number of steps needed are - "+result);
	}
	public static int bfs(int[][] grid, int si, int sj, int ei, int ej)
	{
		int m = grid.length;
		int n = grid[0].length;
		int min = Integer.MAX_VALUE;
		int curr = 0;
		boolean[][] vis = new boolean[m][n];
		LinkedList<Pair> l = new LinkedList<Pair>();
		vis[si][sj] = true;
		l.add(new Pair(new int[]{si,sj}, curr));
		while(!l.isEmpty())
		{
			Pair p = l.removeFirst();
			int[] coord = p.coord;
			curr = p.len;
			if(coord[0]==ei && coord[1]==ej)
			{
				if(min > curr) min = curr;
			}
			if(isValid(coord[0]-1,coord[1],m,n) && grid[coord[0]-1][coord[1]]!=0 && !vis[coord[0]-1][coord[1]])
			{
				vis[coord[0]-1][coord[1]] = true;
				l.add(new Pair(new int[]{coord[0]-1,coord[1]}, curr+1));
			}
			if(isValid(coord[0],coord[1]-1,m,n) && grid[coord[0]][coord[1]-1]!=0 && !vis[coord[0]][coord[1]-1])
			{
				vis[coord[0]][coord[1]-1] = true;
				l.add(new Pair(new int[]{coord[0],coord[1]-1}, curr+1));
			}
			if(isValid(coord[0],coord[1]+1,m,n) && grid[coord[0]][coord[1]+1]!=0 && !vis[coord[0]][coord[1]+1])
			{
				vis[coord[0]][coord[1]+1] = true;
				l.add(new Pair(new int[]{coord[0],coord[1]+1}, curr+1));
			}
			if(isValid(coord[0]+1,coord[1],m,n) && grid[coord[0]+1][coord[1]]!=0 && !vis[coord[0]+1][coord[1]])
			{
				vis[coord[0]+1][coord[1]] = true;
				l.add(new Pair(new int[]{coord[0]+1,coord[1]}, curr+1));
			}
		}
		return min;
	}
	private static boolean isValid(int i, int j, int m, int n)
	{
		return ((i>=0 && i<m) && (j>=0 && j<n));
	}
}
class Pair
{
	int[] coord;
	int len;
	Pair(int[] a, int l)
	{
		coord = a;
		len = l;
	}
}