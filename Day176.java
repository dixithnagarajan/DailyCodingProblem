import java.io.*;
import java.util.*;

public class Day176
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine().trim();
		String input2 = br.readLine().trim();
		br.close();

		boolean result = charMapExists(input1, input2);
		System.out.println("\n\n"+result);
	}
	public static boolean charMapExists(String s1, String s2)
	{
		if(s1 == null) return (s2 == null);
		if(s2 == null) return (s1 == null);
		if(s1.length() != s2.length()) return false;

		int[] map = new int[256];
		Arrays.fill(map, -1);
		boolean[] vis = new boolean[256];
		for(int i=0;i<s1.length();i++)
		{
			if(map[s1.charAt(i)] == -1)
			{
				if(vis[s1.charAt(i)]) return false;
				vis[s1.charAt(i)] = true;
				map[s1.charAt(i)] = s2.charAt(i);
			}
			else if(map[s1.charAt(i)] != s2.charAt(i)) return false;
		}
		return true;
	}
}
