import java.io.*;
import java.util.*;

public class Day161
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine().trim());
		br.close();
		int result = reverse(input);
		System.out.println(result);
		System.out.println(Integer.toString(input, 2)+" "+Integer.toString(result, 2));
	}
	public static int reverse(int n)
	{
		for(int i=0;i<=15;i++)
		{
			int j = 31-i;
			int ith = ((n & (1<<i)) >> i);
			int jth = ((n & (1<<j)) >> j);
			if((ith ^ jth) == 0) continue;

			n = n^(1<<i);
			n = n^(1<<j);
		}
		return n;
	}
}
