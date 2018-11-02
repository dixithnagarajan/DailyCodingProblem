import java.io.*;
import java.util.*;

//This is more related to addresses and pointers. So, it would be better to do it in a whiteboard or in C++
//For now I assumed the existense of get_pointer and dereference_pointer functions to ease my flow

// DO NOT COMPILE THIS FILE !!!

public class Day6
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("###########################################################################################################");
		System.out.println();
		System.out.println("Please enter actions in a space separated line and inputs in a tab separated line")
		System.out.println();
		System.out.println("###########################################################################################################");
		String[] actions = br.readLine().split(" ");
		String inputSingle = br.readLine();
		br.close();
		String[] inputString = inputSingle.split("\t");

		XORLinkedList<Integer> ll = new XORLinkedList<Integer>();
		for(int i=0;i<actions.length();i++)
		{
			if(actions[i].equals(add))
			{
				ll.add(Integer.parseInt(inputString[i]));
			}
			else if(actions[i].equals(get))
			{
				System.out.println("Get at index "+Integer.parseInt(inputString[i])+" is "+ll.get(Integer.parseInt(inputString[i])));
			}
		}
	}
}

class XORLinkedList<T>
{
	XORListNode<T> head;
	XORListNode<T> tail;
	int size;
	XORLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	public void add(T val)
	{
		if(head == null)
		{
			head = new XORListNode<T>(val);
			size++;
		}
		else if(tail == null)
		{
			tail = new XORListNode<T>(val);
			size++;
			tail.npx = get_pointer(head)^get_pointer(null);
			head.npx = get_pointer(null)^get_pointer(tail);
		}
		else
		{
			XORListNode<T> temp = new XORListNode<T>(val);
			size++;
			temp.npx = get_pointer(tail)^get_pointer(null);
			tail.npx = get_pointer(null)^get_pointer(temp);
			tail = temp;
		}
	}
	public T get(int index)
	{
		if((index < 0) || (index >= this.size))
		{
			return null;
		}
		if(index == 0) return head.val;
		if(index == size-1) return tail.val;
		XORListNode<T> temp = head;
		int prev = get_pointer(null);
		while(index > 0)
		{
			XORListNode<T> t = temp;
			temp = dereference_pointer(temp.npx^prev);
			prev = t;
			index--;
		}
		return temp.val;
	}
}
class XORListNode<T>
{
	T val;
	int npx;
	XORListNode(T v)
	{
		val = v;
		npx = get_pointer(null)^get_pointer(null);
	}
}