import java.io.*;
import java.util.*;

public class Day034
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();

		String result = findMinimum(input);
		System.out.println("\n\n"+result);
	}
	public static String findMinimum(String s)
	{
		ArrayList<String> possible = new ArrayList<String>();
		for(int i=0;i<s.length();i++)
		{
			possible.add(s.charAt(i)+"");
			possible.add(s.substring(0,i));
			possible.add(s.substring(i+1, s.length()));
		}
		for(int i=1;i<s.length();i++)
		{
			possible.add("");
			possible.add(s.substring(0,i));
			possible.add(s.substring(i,s.length()));
		}
		ArrayList<String> candids = new ArrayList<String>();
		for(int i=0;i<possible.size();i+=3)
		{
			candids.add(recurse(possible.get(i), possible.get(i+1), possible.get(i+2)));
		}
		String ret = "";
		int len = Integer.MAX_VALUE;
		for(int i=0;i<candids.size();i++)
		{
			if(len > candids.get(i).length())
			{
				len = candids.get(i).length();
				ret = candids.get(i);
			}
			if(len == candids.get(i).length())
			{
				if(candids.get(i).compareTo(ret) <= 0) ret = candids.get(i);
			}
		}
		return ret;
	}
	private static String recurse(String palindrome, String before, String after)
	{
		if((before.length() == 0) || (after.length() == 0))
		{
			if(after.length() == 0)
			{
				return before+palindrome+(new StringBuilder(before).reverse().toString());
			}
			return (new StringBuilder(after).reverse().toString())+palindrome+after;
		}
		if(before.charAt(before.length()-1) == after.charAt(0))
		{
			return recurse(after.charAt(0)+palindrome+after.charAt(0), before.substring(0, before.length()-1), after.substring(1, after.length()));
		}

		String from_before = recurse(before.charAt(before.length()-1)+palindrome+before.charAt(before.length()-1), before.substring(0, before.length()-1), after);
		String from_after = recurse(after.charAt(0)+palindrome+after.charAt(0), before, after.substring(1, after.length()));

		if(from_after.length() == from_before.length())
		{
			if(from_before.compareTo(from_after) <= 0) return from_before;
			return from_after;
		}

		if(from_after.length() < from_before.length()) return from_after;
		return from_before;
	}
}