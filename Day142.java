import java.io.*;
import java.util.*;

public class Day142
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		br.close();
		boolean result = isBalanced(input);
		System.out.println("\n"+result);
	}
	public static boolean isBalanced(String s)
	{
		int lo = 0;
		int hi = 0;
		for (int i=0;i<s.length();i++)
		{

			lo += (s.charAt(i) == '(' ? 1 : -1);
			hi += (s.charAt(i) == ')' ? -1 : 1);
			if (hi<0) break;
			lo = Math.max(lo,0);
		}
		return lo==0;
	}
}
