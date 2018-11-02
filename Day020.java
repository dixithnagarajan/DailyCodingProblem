import java.io.*;
import java.util.*;

public class Day20
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] l1String = br.readLine().split(" ");
		String[] l2String = br.readLine().split(" ");
		br.close();

		ListNode h1 = new ListNode(Integer.parseInt(l1String[0]));
		ListNode h2 = new ListNode(Integer.parseInt(l2String[0]));
		ListNode l1=h1,l2=h2;
		for(int i=1;i<l1String.length;i++)
		{
			l1.next = new ListNode(Integer.parseInt(l1String[i]));
			l1 = l1.next;
		}
		for(int i=1;i<l2String.length;i++)
		{
			l2.next = new ListNode(Integer.parseInt(l2String[i]));
			l2 = l2.next;
		}

		ListNode diffNode = intersect(h1, h2, l1String.length, l2String.length);
		System.out.println((diffNode == null)?"No such intersection exists":diffNode.val);
	}
	public static ListNode intersect(ListNode l1, ListNode l2, int c1, int c2)
	{
		if(c1>c2)
		{
			for(int i=0;i<(c1-c2);i++)
			{
				if(l1 == null) return l1;
				l1 = l1.next;
			}
			while(l1!=null && l2!=null)
			{
				if(l1.val == l2.val) return l1;
				l1 = l1.next;
				l2 = l2.next;
			}
			return null;
		}
		for(int i=0;i<(c2-c1);i++)
		{
			if(l2 == null) return l2;
			l2 = l2.next;
		}
		while(l1!=null && l2!=null)
		{
			if(l1.val == l2.val) return l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		return null;
	}
	
}

class ListNode
{
	int val;
	ListNode next;
	ListNode(int a)
	{
		val = a;
	}
}