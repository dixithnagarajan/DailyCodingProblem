import java.io.*;
import java.util.*;

public class Day114
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		String[] delimString = br.readLine().split(" ");
		br.close();
		HashSet<Character> delims = new HashSet<Character>();
		for(int i=0;i<delimString.length;i++)
		{
			delims.add(delimString[i].charAt(0));
		}
		StringBuilder sb = new StringBuilder(inp);
		String result = reverseWords(sb, delims);
		System.out.println(result);
	}
	public static String reverseWords(StringBuilder sb, HashSet<Character> d)
	{
		ArrayList<String> delims = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		int start = 0;
		int end = 0;
		boolean atStart = false;
		boolean atEnd = false;
		int i = 0;
		while(i < sb.length())
		{
			if(d.contains(sb.charAt(i)))
			{
				StringBuilder s = new StringBuilder();
				end = i-1;
				if(end < 0) atStart = true;
				else
				{
					words.add(sb.substring(start, end+1));
				}
				while(i< sb.length() && d.contains(sb.charAt(i)))
				{
					s.append(sb.charAt(i));
					i++;
				}
				start = i;
				if(start == sb.length())
				{
					atEnd = true;
				}
				delims.add(s.toString());
			}
			else i++;
		}
		if(start != sb.length())
		{
			words.add(sb.substring(start, sb.length()));
		}
		for(i=0;i<(words.size()/2);i++)
		{
			String temp = words.get(i);
			words.set(i, words.get(words.size()-1-i));
			words.set(words.size()-1-i, temp);
		}
		i = 0;
		int j = 0;
		int k = 0;
		if(atStart)
		{
			while(j < delims.get(0).length())
			{
				sb.setCharAt(i, delims.get(0).charAt(j));
				i++;
				j++;
			}
			k = 1;
		}
		for(int iter=0;iter<words.size();iter++)
		{
			j = 0;
			for(;j<words.get(iter).length();j++)
			{
				sb.setCharAt(i, words.get(iter).charAt(j));
				i++;
			}
			j = 0;
			if(iter < words.size()-1)
			{
				for(;j<delims.get(k+iter).length();j++)
				{
					sb.setCharAt(i, delims.get(k+iter).charAt(j));
					i++;
				}
			}
		}
		if(atEnd)
		{
			j = 0;
			while(i<sb.length() && j < delims.get(delims.size()-1).length())
			{
				sb.setCharAt(i, delims.get(delims.size()-1).charAt(j));
				i++;
				j++;
			}
		}
		return sb.toString();
	}
}