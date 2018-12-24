import java.io.*;
import java.util.*;

public class Day159
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		br.close();

		Character result = firstReccuring(input);
		System.out.println((result == null)?"null":result);
	}
	private static Character firstReccuring(String s)
	{
		if(s == null || s.length() == 0) return null;
		if(s.length() == 1) return s.charAt(0);

		int[] freq = new int[256];
		int min=0;
		char minElem;
		for(int i=0;i<s.length();i++)
		{
			if(freq[s.charAt(i)] == 0) freq[s.charAt(i)]++;
			else return s.charAt(i);
		}
		return null;
	}
}
