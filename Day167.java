import java.io.*;
import java.util.*;

public class Day167
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().trim().split("\\s+");
		br.close();
		List<List<Integer>> result = pairPalindromes(words);
		for(int i=0;i<result.size();i++)
		{
			int j = result.get(i).get(0);
			int k = result.get(i).get(1);
			System.out.println("( "+j+", "+k+" ) --> "+words[j]+"+"+words[k]);
		}
	}
	public static List<List<Integer>> pairPalindromes(String[] w)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<w.length;i++)
		{
			map.put(w[i], i);
		}
		if(map.containsKey(""))
		{
			int blk = map.get("");
			for(int i=0;i<w.length;i++)
			{
				if(isPalindrome(w[i]))
				{
					if(i == blk) continue;
					ret.add(Arrays.asList(i, blk));
					ret.add(Arrays.asList(blk, i));
				}
			}
		}
		for(int i=0;i<w.length;i++)
		{
			String revS = reverseOfThisString(w[i]);
			if(map.containsKey(revS))
			{
				int x = map.get(revS);
				if(x == i) continue;
				ret.add(Arrays.asList(i, x));
			}
		}
		for(int i=0;i<w.length;i++)
		{
			for(int cut=1;cut<w[i].length();cut++)
			{
				if(isPalindrome(w[i].substring(0,cut)))
				{
					String revS = reverseOfThisString(w[i].substring(cut));
					if(map.containsKey(revS))
					{
						int x = map.get(revS);
						if(x == i) continue;
						ret.add(Arrays.asList(x, i));
					}
				}
				if(isPalindrome(w[i].substring(cut)))
				{
					String revS = reverseOfThisString(w[i].substring(0,cut));
					if(map.containsKey(revS))
					{
						int x = map.get(revS);
						if(x == i) continue;
						ret.add(Arrays.asList(i, x));
					}
				}
			}
		}
		return ret;
	}
	private static boolean isPalindrome(String s)
	{
		for(int i=0;i<=s.length()/2;i++)
		{
			if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}
	private static String reverseOfThisString(String s)
	{
		return new StringBuilder(s).reverse().toString();
	}
}
