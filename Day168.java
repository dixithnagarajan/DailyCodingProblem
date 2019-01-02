import java.io.*;
import java.util.*;

public class Day168
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] matrix = new int[N][N];
		for(int i=0;i<N;i++)
		{
			String[] inpString = br.readLine().trim().split(" ");
			for(int j=0;j<N;j++)
			{
				matrix[i][j] = Integer.parseInt(inpString[j]);
			}
		}
		br.close();
		rotateClockwise90(matrix);
		print(matrix);
	}
	public static void rotateClockwise90(int[][] m)
	{
		int sr = 0, er = m.length-1;
		int sc = 0, ec = m.length-1;
		if(m == null) return;
		if(m.length == 0 || m.length == 1) return;
		while(sr <= er && sc <= ec)
		{
			for(int i=sr;i<er;i++)
			{
				int temp = m[sr][i];
				m[sr][i] = m[er+sr-i][sc];
				m[er+sr-i][sc] = m[er][ec+sc-i];
				m[er][ec+sc-i] = m[i][ec];
				m[i][ec] = temp;
			}
			sr++;
			sc++;
			er--;
			ec--;
		}
	}
	private static void print(int[][] a)
	{
		System.out.println("\n\n");
		int N = a.length;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
