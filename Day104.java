import java.io.*;
import java.util.*;

public class Day104
{
	public static void main(String[] args)
	{
		SingleNode s          = new SingleNode(1);
		s.next                = new SingleNode(4);
		s.next.next           = new SingleNode(3);
		s.next.next.next      = new SingleNode(4);
		s.next.next.next.next = new SingleNode(1);

		System.out.println(isPalindrome(s));

		s      = new SingleNode(1);
		s.next = new SingleNode(4);

		System.out.println(isPalindrome(s));

		DoubleNode d              = new DoubleNode(1);
		d.next                    = new DoubleNode(4);
		d.next.pre                = d;
		d.next.next               = new DoubleNode(3);
		d.next.next.pre           = d.next;
		d.next.next.next          = new DoubleNode(4);
		d.next.next.next.pre      = d.next.next;
		d.next.next.next.next     = new DoubleNode(1);
		d.next.next.next.next.pre = d.next.next.next;

		System.out.println(isPalindrome(d));

		d          = new DoubleNode(1);
		d.next     = new DoubleNode(4);
		d.next.pre = d;

		System.out.println(isPalindrome(d));
	}
	public static boolean isPalindrome(SingleNode s)
	{
		if(s == null) return true;
		if(s.next == null) return true;

		SingleNode s1 = reverse(s);
		SingleNode t = s;
		SingleNode t1 = s1;
		while(t != null)
		{
			if(t.val != t1.val) return false;
			t = t.next;
			t1 = t1.next;
		}

		return true;
	}
	public static boolean isPalindrome(DoubleNode d)
	{
		if(d == null) return true;
		if(d.next == null) return true;

		DoubleNode e = d;
		int size = 0;
		while(e.next != null)
		{
			e = e.next;
			size++;
		}
		size++;
		for(int i=0;i<(size/2);i++)
		{
			if(d.val != e.val) return false;
			d = d.next;
			e = e.pre;
		}
		return true;
	}
	private static SingleNode reverse(SingleNode s)
	{
		if(s == null) return s;
		if(s.next == null) return s;

		SingleNode t1 = null;
		SingleNode t2 = s;
		SingleNode t3 = s.next;

		while(t2 != null)
		{
			t2.next = t1;

			t1 = t2;
			t2 = t3;
			if(t3 != null) t3 = t3.next;
		}

		s = t1;
		return s;
	}
}

class SingleNode
{
	int val;
	SingleNode next;
	SingleNode(int a)
	{
		val = a;
		next = null;
	}
}

class DoubleNode
{
	int val;
	DoubleNode next, pre;
	DoubleNode(int a)
	{
		val = a;
		next = null;
		pre = null;
	}
}