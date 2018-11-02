import java.io.*;
import java.util.*;

public class Day86
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();

		int result = minToRemove(input);
		System.out.println(result);
	}
	public static int minToRemove(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		int retVal = 0;
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c == '(')
			{
				stack.push(c);
			}
			else
			{
				if(stack.isEmpty()) retVal++;
				else stack.pop();
			}
		}
		return retVal+stack.size();
	}
}