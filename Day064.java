import java.io.*;
import java.util.*;

public class Day064
{
	static int[] xdir = {2,1,1,-2,-1,2,-1,-2};
	static int[] ydir = {1,2,-2,1,2,-1,-2,-1};

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		int result = knightTour(N);
		System.out.println("\n"+result);
	}
	public static int knightTour(int N)
	{
		if(N<=0) return -1;
		int count = 0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int[][] board = new int[N][N];
				board[i][j] = 0;
				int[] tourx = new int[N*N];
				int[] toury = new int[N*N];
				tourx[0] = i;
				toury[0] = j; 
				count += knightTourUtil(board, tourx, toury, 1);
			}
		}
		return count;
	}
	private static int knightTourUtil(int[][] board, int[] tourx, int[] toury, int i)
	{
		if(i == board.length*board.length)
		{
			return 1;
		}
		int count  = 0;
		int r = tourx[i-1];
		int c = toury[i-1];
		ArrayList<Integer> xmoves = new ArrayList<Integer>();
		ArrayList<Integer> ymoves = new ArrayList<Integer>();
		for(int j=0;j<8;j++)
		{
			int newr = r+xdir[j];
			int newc = c+ydir[j];
			if(((newr>0 && newr<board.length) && (newc>0 && newc<board.length)) && (board[newr][newc] == 0))
			{
				xmoves.add(newr);
				ymoves.add(newc);
			}
		}

		for(int j=0;j<xmoves.size();j++)
		{
			tourx[i] = xmoves.get(j);
			toury[i] = ymoves.get(j);
			board[xmoves.get(j)][ymoves.get(j)] = i;
			count += knightTourUtil(board, tourx, toury, i+1);
			tourx[i] = 0;
			toury[i] = 0;
			board[xmoves.get(j)][ymoves.get(j)] = 0;
		}
		return count;
	}
}