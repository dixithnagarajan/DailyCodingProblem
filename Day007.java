import java.io.*;
import java.util.*;

public class Day7
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine().trim().replaceAll("( )+"," ");
		br.close();
		if(!validateInput(inp)) System.out.println("Input format incorrect. Exiting ....");
		else
		{
			if(inp.equals("")) System.out.println("");
			else
			{
				ArrayList<String> l = new ArrayList<String>();
				int[] i = new int[1];
				decodedStrings(inp, new StringBuilder(), i, l);
				System.out.println(l.toString());
			}
		}
	}
	private static void decodedStrings(String s, StringBuilder sb, int[] i, ArrayList<String> l)
	{
		if(i[0] == s.length())
		{
			l.add(sb.toString());
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		int j = i[0];
		if(s.charAt(j) == '0')
		{
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		sb.append(decode(s.charAt(j)-'0'));
		i[0]++;
		decodedStrings(s, sb, i, l);
		i[0] = j;
		if(j+1 < s.length())
		{
			if(Integer.parseInt(s.substring(j,j+2)) <=26)
			{
				sb.append(decode(Integer.parseInt(s.substring(j,j+2))));
				i[0]+=2;
				decodedStrings(s,sb,i,l);
				if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
			}
			else
			{
				sb.deleteCharAt(sb.length()-1);
			}
		}
		else
		{
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	private static char decode(int i)
	{
		return (char)(i+96);
	}
	private static boolean validateInput(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			if(!Character.isDigit(s.charAt(i))) return false;
		}
		return true;
	}
}