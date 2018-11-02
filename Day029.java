import java.io.*;
import java.util.*;

public class Day29
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		br.close();

		String enc = encode(inp);
		System.out.println("The encoded string is - "+enc);
		String dec = decode(enc);
		System.out.println("The decoded string is - "+dec);
	}
	public static String encode(String s)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();)
		{
			char c = s.charAt(i);
			int count = 0;
			while((i<s.length()) && (s.charAt(i) == c))
			{
				count++;
				i++;
			}
			sb.append(count);
			sb.append(c);
		}

		return sb.toString();
	}
	public static String decode(String s)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i+=2)
		{
			int count = s.charAt(i)-'0';
			char c = s.charAt(i+1);

			for(int j=0;j<count;j++)
			{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}