import java.io.*;
import java.util.*;

public class Day103
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] charString = br.readLine().split(" ");
		br.close();
		char[] chars = new char[charString.length];
		for(int i=0;i<chars.length;i++)
		{
			chars[i] = charString[i].charAt(0);
		}

		String result = findSubString(input, chars);
		System.out.println("\n"+result);
	}
	public static String findSubString(String s, char[] c)
	{
		int[] hash_str = new int[256];
		int[] hash_pat = new int[256];

		if(s.length() < c.length) return null;
		for(int i=0;i<c.length;i++)
		{
			hash_pat[c[i]]++; 
		}
		int min = Integer.MAX_VALUE;
		int start = 0;
		int start_ind = -1;
		int count = 0;
		for(int i=0;i<s.length();i++)
		{
			hash_str[s.charAt(i)]++;
			if(hash_pat[s.charAt(i)] != 0 && hash_str[s.charAt(i)] <= hash_pat[s.charAt(i)]) count++;

			if(count == c.length)
			{
				while(hash_str[s.charAt(start)] > hash_pat[s.charAt(start)] || hash_pat[s.charAt(start)] == 0)
				{
					if(hash_str[s.charAt(start)] > hash_pat[s.charAt(start)]) hash_str[s.charAt(start)]--;
					start++;
				}
				if(min > (i-start+1))
				{
					min = i-start+1;
					start_ind = start;
				}
			}
		}
		if(start_ind == -1) return null;
		return s.substring(start_ind, start_ind+min);
	}
}