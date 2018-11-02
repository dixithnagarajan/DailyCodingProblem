import java.io.*;
import java.util.*;

public class Day38
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int result = numberOfWays(N);
		System.out.println("\n"+result);
	}
	public static int numberOfWays(int N)
	{
		ArrayList<Integer> board = new ArrayList<Integer>();
		return numberOfWays(N, board);
	}
	private static int numberOfWays(int N, ArrayList<Integer> board)
	{
		if(board.size() == N)
		{
			return 1;
		}
		int ret = 0;
		for(int j=0;j<N;j++)
		{
			board.add(j);
			if(isValid(board)) ret+=numberOfWays(N, board);
			board.remove(board.size()-1);
		}
		return ret;
	}
	private static boolean isValid(List<Integer> board)
	{
		int curr_row = board.size()-1;
		int curr_col = board.get(board.size()-1);

		for(int k=0;k<(board.size()-1);k++)
		{
			int dif = Math.abs(curr_col-board.get(k));
			if(dif == 0 || dif == (curr_row-k)) return false;
		}
		return true;
	}	
}