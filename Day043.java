import java.io.*;
import java.util.*;

public class Day43
{
	private Stack<Integer> s;
	private Stack<Integer> maxS;

	public Day43()
	{
		s = new Stack<Integer>();
		maxS = new Stack<Integer>();
	}
	public int size()
	{
		return s.size();
	}
	public boolean isEmpty()
	{
		return s.empty();
	}
	public int max()
	{
		if(maxS.empty()) return -1;
		return maxS.peek();
	}
	public void push(int val)
	{
		if(s.empty())
		{
			s.push(val);
			maxS.push(val);
		}
		else
		{
			s.push(val);
			if(val > maxS.peek())
			{
				maxS.push(val);
			}
			else
			{
				maxS.push(maxS.peek());
			}
		}
	}
	public int pop()
	{
		if(s.empty()) return -1;
		maxS.pop();
		return s.pop();
	}
	public int peek()
	{
		if(s.empty()) return -1;
		return s.peek();
	}

	public static void main(String[] args)
	{
		Day43 s = new Day43();

		System.out.println(s.max());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.isEmpty());

		s.push(4);

		System.out.println(s.max());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.isEmpty());

		s.push(19);

		System.out.println(s.max());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.isEmpty());

		s.push(7);

		System.out.println(s.max());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.isEmpty());

		s.push(14);

		System.out.println(s.max());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.isEmpty());

		s.push(20);

		System.out.println(s.max());
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.isEmpty());
	}
}