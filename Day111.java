import java.io.*;
import java.util.*;

public class Day111
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String W = br.readLine();
		String S = br.readLine();
		br.close();

		ArrayList<Integer> result = substringAnagram(W, S);
		if(result == null)
		{
			System.out.println("No such substrings exist!");
		}
		else
		{
			System.out.println(result.toString());
		}
	}
	public static ArrayList<Integer> substringAnagram(String w, String s)
	{
		if(w.length() > s.length()) return null;
		ArrayList<Integer> ret = new ArrayList<Integer>();

		int[] pat = new int[256];
		int[] text = new int[256];

		for(int i=0;i<w.length();i++)
		{
			pat[w.charAt(i)]++;
			text[s.charAt(i)]++;
		}

		for(int i=w.length();i<s.length();i++)
		{
			if(compare(pat, text)) ret.add(i-w.length());

			text[s.charAt(i-w.length())]--;
			text[s.charAt(i)]++;
		}

		if(compare(pat, text)) ret.add(s.length()-w.length());

		return ret;
	}
	private static boolean compare(int[] a, int[] b)
	{
		if(a.length != b.length) return false;
		for(int i=0;i<a.length;i++)
		{
			if(a[i] != b[i]) return false;
		}
		return true;
	}
}