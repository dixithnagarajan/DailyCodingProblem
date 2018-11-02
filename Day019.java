import java.io.*;
import java.util.*;

public class Day19
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("#############################################################");
		System.out.println("Please enter the dimensions of the array as space separated\nvalues in line 1 and then the array in row major formin the\nsubsequent lines");
		System.out.println("#############################################################");
		int m,n;
		String[] matDimensions = br.readLine().split(" ");
		m = Integer.parseInt(matDimensions[0]);
		n = Integer.parseInt(matDimensions[1]);

		int[][] matrix = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String[] entries = br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				matrix[i][j] = Integer.parseInt(entries[j]);
			}
		}

		System.out.println("The minimum cost to paint is - "+minCost(matrix));
	}
	public static int minCost(int[][] mat)
	{
		int m = mat.length;
		int n = mat[0].length;
		int[] best = new int[n];
		for(int i=0;i<m;i++)
		{
			int[] temp = new int[n];
			for(int j=0;j<n;j++)
			{
				if(j == 0) temp[j] = mat[i][j]+min(best,j+1,n-1);
				else if(j == n-1) temp[j] = mat[i][j]+min(best,0,j-1);
				else temp[j] = mat[i][j]+Math.min(min(best,0,j-1),min(best,j+1,n-1));
			}
			best = temp;
		}
		return min(best,0,n-1);
	}
	private static int min(int[] arr, int start, int end)
	{
		if(start > end) return 0;
		int min = arr[start];
		for(int i=start;i<=end;i++)
		{
			if(arr[i] < min) min = arr[i];
		}
		return min;
	}
}