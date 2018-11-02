import java.io.*;
import java.util.*;

public class Day53<T>
{
	Stack<T> s1;
	Stack<T> s2;

	public Day53()
	{
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	public boolean isEmpty()
	{
		return s1.isEmpty()&&s2.isEmpty();
	}
	public int size()
	{
		return s1.size()+s2.size();
	}
	public void enqueue(T val)
	{
		s1.push(val);
	}
	public T dequeue()
	{
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				T temp = s1.pop();
				s2.push(temp);
			}
		}
		return s2.pop();
	}
}