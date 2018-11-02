import java.io.*;
import java.util.*;

public class Day074
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int N = Integer.parseInt(inpString[0]);
		int X = Integer.parseInt(inpString[1]);
		
		int result = numberInGrid(N, X);
		System.out.println("\n"+result);
	}
	public static int numberInGrid(int N, int X)
	{
		if(X > N*N) return 0;
		if(X == N*N || X == 1) return 1;
		int ret = 0;
		for(int i=1;i<=Math.sqrt(X);i++)
		{
			if(X%i == 0)
			{
				int thisOne = i;
				int otherOne = X/i;

				if(thisOne<=N && otherOne<=N)
				{
					if(thisOne == otherOne) ret+=1;
					else ret+=2;
				}
			}
		}
		return ret;
	}
}