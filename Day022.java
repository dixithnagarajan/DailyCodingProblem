import java.io.*;
import java.util.*;

public class Day22
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("######################################################################");
		System.out.println("Please enter the dictionary in one line and search string in another");
		System.out.println("######################################################################");

		String[] dict = br.readLine().split(" ");
		String search = br.readLine();
		br.close();
		TrieNode root = new TrieNode();
		for(int i=0;i<dict.length;i++)
		{
			root.add(dict[i]);
		}
		ArrayList<String> results = new ArrayList<String>();
		wordBreak(search, root, results);
		System.out.println(results.toString());
	}
	public static void wordBreak(String s, TrieNode r, ArrayList<String> results)
	{
		wordBreakHelper(s,r,s.length(),"", results);
	}
	private static void wordBreakHelper(String s, TrieNode r, int n, String res, ArrayList<String> results)
	{
		for(int i=1;i<=n;i++)
		{
			String pre = s.substring(0,i);
			if(r.isAWord(pre))
			{
				if(i == n)
				{
					res+=pre;
					results.add(res);
				}
				wordBreakHelper(s.substring(i,n),r,n-i,res+pre+" ", results);
			}
		}
	}
}