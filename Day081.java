import java.io.*;
import java.util.*;

public class Day81
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		input = input.trim().replaceAll("( )*","");
		HashMap<Character, String> hm = new HashMap();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");
		List<String> l = new ArrayList<String>();
		List<StringBuilder> ll = new ArrayList<StringBuilder>();
		if(!validateInput(input))
		{
			System.out.println("Invalid Input. Exiting ....");
		}
		else
		{
			for(int i=0;i<input.length();i++)
			{
				if(i == 0)
				{
					String s = hm.get(input.charAt(i));
					for(int j=0;j<s.length();j++)
					{
						ll.add(new StringBuilder(Character.toString(s.charAt(j))));
					}
				}
				else
				{
					String s = hm.get(input.charAt(i));
					List<StringBuilder> temp = new ArrayList<StringBuilder>();
					for(int j=0;j<ll.size();j++)
					{
						for(int k=0;k<s.length();k++)
						{
							temp.add(new StringBuilder(ll.get(j).toString()+(s.charAt(k))));
						}
					}
					ll = temp;
				}
			}

			for(int i=0;i<ll.size();i++)
			{
				l.add(ll.get(i).toString());
			}
			System.out.println(l.toString());
		}
	}
	private static boolean validateInput(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			if(!Character.isDigit(s.charAt(i))) return false;
			if((s.charAt(i) == '1') || (s.charAt(i) == '0')) return false;
		}
		return true;
	}
}
