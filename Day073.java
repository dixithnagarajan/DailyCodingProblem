import java.io.*;
import java.util.*;

public class Day73
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] listString = br.readLine().split(" ");
		br.close();
		ListNode head = new ListNode(Integer.parseInt(listString[0]));
		ListNode temp = head;
		for(int i=1;i<listString.length;i++)
		{
			temp.next = new ListNode(Integer.parseInt(listString[i]));
			temp = temp.next;
		}

		temp = head;
		System.out.println("Before reversing, the list is -");
		while(temp!=null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println();
		head = reverse(head);
		System.out.println("After reversing, the list is -");
		temp = head;
		while(temp!=null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println();
	}
	public static ListNode reverse(ListNode h)
	{
		if(h == null) return h;
		if(h.next == null) return h;
		ListNode t2 = null;
		ListNode t = h;
		ListNode t1 = h.next;
		while(t!=null)
		{
			t.next = t2;
			t2 = t;
			t = t1;
			if(t1!=null) t1 = t1.next;
		}
		return t2;
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