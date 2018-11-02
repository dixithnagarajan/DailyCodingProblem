import java.io.*;
import java.util.*;

public class Day65
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] mat = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				mat[i][j] = Integer.parseInt(inpString[j]);
			}
		}
		br.close();

		printSpiral(mat);
	}
	public static void printSpiral(int[][] mat)
	{
		int m = mat.length;
		int n = mat[0].length;

		int dir = 0;
		int rs = 0;
		int re = m-1;
		int cs = 0;
		int ce = n-1;

		while(rs<=re && cs<=ce)
		{
			if(dir == 0)
			{
				for(int i=cs;i<=ce;i++)
				{
					System.out.println(mat[rs][i]);
				}
				rs++;
			}
			if(dir == 1)
			{
				for(int i=rs;i<=re;i++)
				{
					System.out.println(mat[i][ce]);
				}
				ce--;
			}
			if(dir == 2)
			{
				for(int i=ce;i>=cs;i--)
				{
					System.out.println(mat[re][i]);
				}
				re--;
			}
			if(dir == 3)
			{
				for(int i=re;i>=rs;i--)
				{
					System.out.println(mat[i][cs]);
				}
				cs++;
			}
			dir = (dir+1)%4;
		}
	}
}