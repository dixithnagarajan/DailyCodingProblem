import java.io.*;
import java.util.*;

public class Day145
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] llString = br.readLine().split(" ");
		br.close();
		ListNode list = new ListNode(Integer.parseInt(llString[0]));
		ListNode temp = list;
		for(int i=1;i<llString.length;i++)
		{
			temp.next = new ListNode(Integer.parseInt(llString[i]));
			temp = temp.next;
		}
		ListNode head = jumble(list);
		temp = head;
		while(temp != null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println();
	}
	public static ListNode jumble(ListNode l)
	{
		if(l == null || l.next == null) return l;
		ListNode t = l;
		ListNode t1 = l.next;
		ListNode t2 = null;
		ListNode t1Store = t1;
		while(t != null && t1 != null)
		{
			t.next = t1.next;
			t1.next = t;
			if(t2 != null) t2.next = t1;
			t2 = t;
			t = t.next;
			if(t != null) t1 = t.next;
		}
		return t1Store;
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
