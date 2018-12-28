import java.io.*;
import java.util.*;

public class Day163
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split(" ");
		br.close();
		int result = evaluateReversePolish(inpString);
		System.out.println("\n\n"+result);
	}
	public static int evaluateReversePolish(String[] inp)
	{
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<inp.length;i++)
		{
			try
			{
				int x = Integer.parseInt(inp[i]);
				s.push(x);
			}
			catch(NumberFormatException nfe)
			{
				char c = inp[i].charAt(0);
				if(c == '+')
				{
					int b = s.pop();
					int a = s.pop();
					s.push(a+b);
				}
				if(c == '-')
				{
					int b = s.pop();
					int a = s.pop();
					s.push(a-b);
				}
				if(c == '*')
				{
					int b = s.pop();
					int a = s.pop();
					s.push(a*b);
				}
				if(c == '/')
				{
					int b = s.pop();
					int a = s.pop();
					s.push(a/b);
				}
			}
		}
		return s.pop();
	}
}
