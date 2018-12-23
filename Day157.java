import java.io.*;
import java.util.*;

public class Day157
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		br.close();
		boolean result = canBePalindrome(input);
		System.out.println(result);
	}
	public static boolean canBePalindrome(String s)
	{
		if(s == null || s.length() == 0 || s.length() == 1) return true;
		boolean isOdd = ((s.length()&1) == 0)?false:true;
		int[] freq = new int[256];
		for(int i=0;i<s.length();i++)
		{
			freq[s.charAt(i)]++;
		}
		for(int i=0;i<256;i++)
		{
			if((freq[i]&1) == 1)
			{
				if(isOdd) isOdd = false;
				else return false;
			}
		}
		return true;
	}
}
