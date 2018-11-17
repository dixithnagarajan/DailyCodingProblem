import java.io.*;
import java.util.*;

public class Day123
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		boolean result = isNumber(input);
		System.out.println("\n"+result);
	}
	public static boolean isNumber(String s)
	{
		if(s == null || s.length() == 0) return false;
		s = s.trim();
		int n = s.length();
		if(n == 1) return Character.isDigit(s.charAt(0));
		int negInd = -1;
		int decimalInd = -1;
		int expInd = -1;
		for(int i=0;i<n;i++)
		{
			if(!Character.isDigit(s.charAt(i)))
			{
				if(s.charAt(i) == '-')
				{
					if(i != 0) return false;
					negInd = i;
				}
				else if(s.charAt(i) == '.')
				{
					if(decimalInd != -1) return false;
					decimalInd = i;
					if(decimalInd <= negInd) return false;
					// This code gives .5 as true. Add an extra condition to check if decimalInd <=0 to return false;
				}
				else if(s.charAt(i) == 'e')
				{
					expInd = i;
					if(!isInteger(s.substring(i+1))) return false;
					if(isNumber(s.substring(0,i))) return true;
				}
				else return false;
			}
		}
		return true;
	}
	private static boolean isInteger(String s)
	{
		if(s == null || s.isEmpty()) return false;
		int i = 0;
		if(s.charAt(i) == '-')
		{
			if(s.length() == 1) return false;
			i = 1;
		}
		for(;i<s.length();i++)
		{
			if(!Character.isDigit(s.charAt(i))) return false;
		}
		return true;
	}
}