import java.io.*;
import java.util.*;

public class Day128
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		towerOfHanoi(n);
	}
	public static void towerOfHanoi(int n)
	{
		towerOfHanoiHelper(n, 1, 3, 2);
	}
	private static void towerOfHanoiHelper(int n, int from, int to, int aux)
	{
		if(n == 1)
		{
			System.out.println("Move "+from+" to "+to);
			return;
		}
		towerOfHanoiHelper(n-1, from, aux, to);
		System.out.println("Move "+from+" to "+to);
		towerOfHanoiHelper(n-1, aux, to, from);
	}
}