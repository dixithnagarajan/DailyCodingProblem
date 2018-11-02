import java.io.*;
import java.util.*;

public class Day076
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimString = br.readLine().split(" ");
		int M = Integer.parseInt(dimString[0]);
		int N = Integer.parseInt(dimString[1]);
		char[][] matrix = new char[M][N];
		for(int i=0;i<M;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				matrix[i][j] = inpString[j].charAt(0);
			}
		}
		br.close();

		int result = numberToDelete(matrix);
		System.out.println("\n\n"+result);
	}
	public static int numberToDelete(char[][] mat)
	{
		int ret = 0;
		if(mat.length == 1) return ret;
		for(int j=0;j<mat[0].length;j++)
		{
			int i = 0;
			for(i=1;i<mat.length;i++)
			{
				if(mat[i][j] < mat[i-1][j]) break;
			}
			if(i != mat.length) ret++;
		}
		return ret;
	}
}