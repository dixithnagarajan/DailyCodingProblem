import java.io.*;
import java.util.*;

public class Day052
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		LRU<Integer, Integer> cache = new LRU<Integer, Integer>(N);
		while(sc.hasNextLine())
		{
			String[] action = sc.nextLine().split(" ");
			if(action[0].equals("set")) cache.set(Integer.parseInt(action[1]),Integer.parseInt(action[2]));
			else
			{
				System.out.println("The result of GET is - "+cache.get(Integer.parseInt(action[1])));
			}
		}
		sc.close();
	}
}

class Node
{
	Object k;
	Object v;
	Node next, prev;

	Node(Object a, Object b)
	{
		k = a;
		v = b;
		next = null;
		prev = null;
	}
}

class LRU<Key extends Comparable<Key>, Value>
{
	HashMap<Key, Node> map = new HashMap<Key, Node>();
	Node head;
	Node tail;
	int N;

	LRU(int a)
	{
		N = a;
	}

	int getCapacity()
	{
		return N;
	}
	
	void set(Key k, Value v)
	{
		if(map.containsKey(k))
		{
			Node old = map.get(k);
			old.v = v;
			remove(old);
			setHead(old);
		}
		else
		{
			if(map.size() >= N)
			{
				Node n = new Node(k,v);
				map.remove(tail.k);
				remove(tail);
				setHead(n);
				map.put(k, n);
			}
			else
			{
				Node n = new Node(k,v);
				setHead(n);
				map.put(k, n);
			}
		}
	}
	Value get(Key k)
	{
		if(!map.containsKey(k)) return null;
		Node n = map.get(k);
		remove(n);
		setHead(n);
		return (Value)n.v;
	}

	void setHead(Node n)
	{
		n.next = head;
		n.prev = null;
		if(head != null) head.prev = n;
		head = n;
		if(tail == null) tail = head;
	}
	void remove(Node n)
	{
		if(n.prev != null)
		{
			n.prev.next = n.next;
		}
		else
		{
			head = n.next;
		}

		if(n.next != null)
		{
			n.next.prev = n.prev;
		}
		else
		{
			tail = n.prev;
		}
	}
}