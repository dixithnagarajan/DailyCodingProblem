import java.io.*;
import java.util.*;

public class Day054
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		for(int i=0;i<9;i++)
		{
			String[] rowString = br.readLine().split(" ");
			for(int j=0;j<9;j++)
			{
				sudoku[i][j] = Integer.parseInt(rowString[j]);
			}
		}
		br.close();

		if(solveSudoku(sudoku))
		{
			System.out.println("Yes, this is possible.\n");
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					System.out.print(sudoku[i][j]+" ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("No, this is not possible.");
		}
	}
	public static boolean solveSudoku(int[][] s)
	{
		int row = 0;
		int col = 0;
		boolean isEmpty = true;
		for(row=0;row<9;row++)
		{
			for(col=0;col<9;col++)
			{
				if(s[row][col] == 0)
				{
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty) break;
		}
		if(isEmpty) return true;
		for(int num=1;num<=9;num++)
		{
			if(isValid(s,num,row,col))
			{
				s[row][col] = num;
				if(solveSudoku(s)) return true;
				else s[row][col] = 0;
			}
		}
		return false;
	}
	private static boolean isValid(int[][]s, int a, int i, int j)
	{
		for(int col=0;col<9;col++)
		{
			if(s[i][col] == a) return false;
		}
		for(int row=0;row<9;row++)
		{
			if(s[row][j] == a) return false;
		}
		int ii = i-(i%3);
		int jj = j-(j%3);
		for(int iii=ii;iii<(ii+3);iii++)
		{
			for(int jjj=jj;jjj<(jj+3);jjj++)
			{
				if(s[iii][jjj] == a) return false;
			}
		}
		return true;
	}
}