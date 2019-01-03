import java.io.*;
import java.util.*;

public class Day169
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split(" ");
		br.close();
		ListNode l = new ListNode(Integer.parseInt(inpString[0]));
		ListNode temp = l;
		for(int i=1;i<inpString.length;i++)
		{
			temp.next = new ListNode(Integer.parseInt(inpString[i]));
			temp = temp.next;
		}
		l = sort(l);
		System.out.println("\n\n");
		temp = l;
		while(temp != null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
	}
	public static ListNode sort(ListNode l)
	{
		if(l == null || l.next == null) return l;
		ListNode slow = l;
		ListNode fast = l.next.next;
		while(slow != null && fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode l2 = slow.next;
		slow.next = null;
		ListNode l1 = l;
		l1 = sort(l1);
		l2 = sort(l2);
		if(l1.val > l2.val)
		{
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		ListNode l1hold = l1;
		ListNode l1p = l1;
		l1 = l1.next;
		while(l1 != null && l2 != null)
		{
			if(l1.val <= l2.val)
			{
				l1p = l1;
				l1 = l1.next;
			}
			else
			{
				ListNode l2n = l2.next;
				l2.next = null;
				l2.next = l1p.next;
				l1p.next = l2;
				l1p = l1p.next;
				l2 = l2n;
			}
		}
		if(l1 == null && l2 != null)
		{
			l1p.next = l2;
		}
		return l1hold;
	}
	private static void print(ListNode l)
	{
		ListNode temp = l;
		while(temp != null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println();
	}
}

class ListNode
{
	int val;
	ListNode next;
	ListNode(int a)
	{
		val = a;
		next = null;
	}
}
