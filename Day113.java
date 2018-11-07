import java.io.*;
import java.util.*;

public class Day113
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		br.close();
		inp = inp.trim().replaceAll("\\s+"," ");
		String result = reverseWords(inp);
		System.out.println(result);
		StringBuilder sb = new StringBuilder(inp);
		reverseWords(sb);
		System.out.println(sb);
	}
	public static String reverseWords(String s)
	{
		String[] words = s.split(" ");
		for(int i=0;i<=(words.length/2);i++)
		{
			String temp = words[i];
			words[i] = words[words.length-1-i];
			words[words.length-1-i] = temp;
		}
		String ret = "";
		for(int i=0;i<words.length;i++)
		{
			ret += words[i]+((i == words.length-1)?"":" ");
		}
		return ret;
	}
	public static void reverseWords(StringBuilder sb)
	{
		sb = sb.reverse();
		int start = 0;
		for(int i=0;i<sb.length();i++)
		{
			if(sb.charAt(i) == ' ')
			{
				reverse(sb, start, i-1);
				start = i+1;
			}
		}
		reverse(sb,start, sb.length()-1);
	}
	private static void reverse(StringBuilder sb, int start, int end)
	{
		if(start > end) return;
		int mid = start+((end-start)/2);
		for(int i=start;i<=mid;i++)
		{
			char temp = sb.charAt(end+start-i);
			sb.setCharAt(end+start-i, sb.charAt(i));
			sb.setCharAt(i, temp);
		}
	}
}