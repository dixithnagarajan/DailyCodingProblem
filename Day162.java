import java.io.*;
import java.util.*;

public class Day162
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().trim().split(" ");
		br.close();
		String[] result = uniquePrefix(words);
		for(String s: result)
		{
			System.out.print(s+" ");
		}
	}
	public static String[] uniquePrefix(String[] w)
	{
		TrieNode t = new TrieNode();
		for(String s: w)
		{
			t.add(s);
		}
		TrieNode temp = t;
		String[] ret = new String[w.length];
		int count = 0;
		for(String s: w)
		{
			int res = 1;
			temp = t.kinder.get(s.charAt(0));
			for(int i=1;i<(s.length());i++)
			{
				if(temp.kinder.size() > 1) res = i+1;
				temp = temp.kinder.get(s.charAt(i));
			}
			if(temp.kinder.size() != 0) ret[count] = "";
			else ret[count] = s.substring(0,res);
			count++;
		}
		return ret;
	}
}
