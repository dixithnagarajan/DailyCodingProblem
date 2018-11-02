import java.io.*;
import java.util.*;

public class Day11
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
		ArrayList<String> results = root.search(search);
		if(results!=null && results.size()>0) System.out.println("The suggestions are - "+results.toString());
		else System.out.println("No such suggestions");
	}
}