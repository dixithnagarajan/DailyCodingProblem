import java.io.*;
import java.util.*;

public class Day153
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().trim().split(" ");
		String word1 = br.readLine().trim();
		String word2 = br.readLine().trim();
		br.close();

		int result = minDistance(words, word1, word2);
		System.out.println("\n\n"+result);
	}
	public static int minDistance(String[] words, String w1, String w2)
	{
		int m=-1,n=-1;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++)
		{
			if(words[i].equals(w1))
			{
				m = i;
				if(n != -1) min = Math.min(min, m-n);
			}
			else if(words[i].equals(w2))
			{
				n = i;
				if(m != -1) min = Math.min(min, n-m);
			}
		}
		return min;
	}
}
