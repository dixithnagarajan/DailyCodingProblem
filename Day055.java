import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Day55
{
	private static HashMap<String, String> urlDict = new HashMap<String, String>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String url = br.readLine();
		br.close();
		String sh = shorten(url);
		System.out.println("The shortened url is - "+sh);
		System.out.println("The restored version is - "+restore(sh));
	}

	public static String shorten(String s)
	{
		for(String key: urlDict.keySet())
		{
			if(s.equals(urlDict.get(key))) return key;
		}
		int l = 0;
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		String alnum = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		while(l<6)
		{
			int i = r.nextInt(alnum.length());
			sb.append(alnum.charAt(i));
			l++;
		}
		urlDict.put(sb.toString(),s);
		return sb.toString();
	}
	public static String restore(String s)
	{
		if(s.length() != 6)
		{
			System.out.println("Invalid input for restore.");
			return null;
		}
		return urlDict.get(s);
	}
}