import java.io.*;
import java.util.*;

public class Day46
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String maxString = maxPalindromeSubString(input);
		System.out.println(maxString);
	}
	public static String maxPalindromeSubString(String s)
	{
		if(s.length() == 1) return s;
		if(s.length() == 2)
		{
			if(s.charAt(0) == s.charAt(1)) return s;
			return s.substring(0,2);
		}
		int maxLen = 1;
		int start = 0;
		for(int i=1;i<s.length();i++)
		{
			int hi = i+1;
			int lo = i-1;
			while(lo>=0 && hi<s.length() && (s.charAt(lo) == s.charAt(hi)))
			{
				if(hi-lo+1 > maxLen)
				{
					maxLen = hi-lo+1;
					start = lo;
				}
				lo--;
				hi++;
			}
			hi = i;
			lo = i-1;
			while(lo>=0 && hi<s.length() && (s.charAt(lo) == s.charAt(hi)))
			{
				if(hi-lo+1 > maxLen)
				{
					maxLen = hi-lo+1;
					start = lo;
				}
				lo--;
				hi++;
			}
		}
		return s.substring(start, start+maxLen);
	}
}