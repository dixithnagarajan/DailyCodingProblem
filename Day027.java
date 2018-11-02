import java.io.*;
import java.util.*;

public class Day27
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();

		if(isBalanced(input)) System.out.println("Yes, the string is balanced");
		else System.out.println("No, the string is not balanced");
	}
	public static boolean isBalanced(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c=='(' || c=='{' || c=='[') stack.push(c);
			else if(c == ')')
			{
				if(stack.isEmpty()) return false;
				if(!(stack.pop() == '(')) return false;
			}
			else if(c == '}')
			{
				if(stack.isEmpty()) return false;
				if(!(stack.pop() == '{')) return false;
			}
			else if(c == ']')
			{
				if(stack.isEmpty()) return false;
				if(!(stack.pop() == '[')) return false;
			}
		}
		return stack.isEmpty();
	}
}