import java.io.*;
import java.util.*;

public class Day13
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		int k = Integer.parseInt(br.readLine());
		br.close();
		if((inp == null) || (inp.length() == 0))
		{
			System.out.println("Invalid String. Exiting ...");
		}
		else if(k<=0)
		{
			System.out.println("Invalid input for k. Exiting ...");
		}
		else
		{
			String s = maxSubSeq(inp, k);
			System.out.println((s == null) ? "To high k compared to unique characters in input" : s);
		}
	}
	public static String maxSubSeq(String s, int k)
	{
		int[] count = new int[256];
		int unique = 0;
		for(int i=0;i<s.length();i++)
		{
			if(count[s.charAt(i)] == 0) unique++;
			count[s.charAt(i)]++;
		}

		if(k == unique) return s;
		if(k>unique) return null;

		for(int i=0;i<256;i++)
		{
			count[i] = 0;
		}

		int curr_start = 0;

		int max_start = 0;
		int max_length = 0;

		count[s.charAt(0)]++;
		for(int i=1;i<s.length();i++)
		{
			count[s.charAt(i)]++;
			while(!valid(count, k))
			{
				count[s.charAt(curr_start)]--;
				curr_start++;
			}
			if(i-curr_start+1 > max_length)
			{
				max_start = curr_start;
				max_length = i-curr_start+1;
			}
		}
		return s.substring(max_start, max_length+max_start);
	}
	private static boolean valid(int[] c, int a)
	{
		int val = 0;
		for(int i=0;i<c.length;i++)
		{
			if(c[i] > 0) val++;
		}
		return (val<=a);
	}
}