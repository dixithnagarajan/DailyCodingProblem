import java.io.*;
import java.util.*;

public class Day177
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split("\\s+");
		int k = Integer.parseInt(br.readLine().trim());
		br.close();
		ListNode l = new ListNode(Integer.parseInt(inpString[0]));
		ListNode temp = l;
		for(int i=1;i<inpString.length;i++)
		{
			temp.next = new ListNode(Integer.parseInt(inpString[i]));
			temp = temp.next;
		}
		ListNode result = rotateRight(l, k);
		temp = result;
		System.out.println("\n\n");
		while(temp != null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
	}
	public static ListNode rotateRight(ListNode l, int k)
	{
		if(l == null || l.next == null) return l;
		if(k == 0) return l;
		int n = size(l);
		k = k%n;
		if(k == 0) return l;
		k = n-k;
		ListNode head = l;
		ListNode tail = l;
		while(tail.next != null)
		{
			tail = tail.next;
		}
		while(k > 0)
		{
			ListNode detach = head;
			head = head.next;
			detach.next = null;
			tail.next = detach;
			tail = tail.next;
			k--;
		}
		return head;
	}
	private static int size(ListNode l)
	{
		int n = 0;
		while(l != null)
		{
			n++;
			l = l.next;
		}
		return n;
	}
}

class ListNode
{
	int val;
	ListNode next;
	ListNode(int a)
	{
		this.val = a;
		next = null;
	}
}
