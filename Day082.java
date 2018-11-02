import java.io.*;
import java.util.*;

public class Day82
{
	String fileName;
	BufferedReader br;

	public Day82(String s) throws FileNotFoundException
	{
		fileName = s;
		br = new BufferedReader(new FileReader(s));
	}

	public String read7() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<7;i++)
		{
			int c = br.read();
			if(c == -1) return sb.toString();
			sb.append((char)c);
		}
		return sb.toString();
	}

	public String readN(int n) throws IOException
	{
		if(n<0) return null;
		if(n == 0) return "";
		if(n%7 == 0)
		{
			int times = n/7;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<times;i++)
			{
				sb.append(read7());
			}
			return sb.toString();
		}
		int times = n/7;
		int last = n%7;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<times;i++)
		{
			sb.append(read7());
		}
		String l = read7();
		if(l.length() <= last) return sb.append(l).toString();
		return sb.append(l.substring(0,last)).toString();
	}

	public static void main(String[] args) throws IOException
	{
		Day82 r = new Day82("hello.txt");
		System.out.println(r.readN(72));
	}
}