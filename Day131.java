import java.io.*;
import java.util.*;

public class Day131
{
	public static void main(String[] args)
	{
		ListNode head            = new ListNode(1);
		head.next                = new ListNode(2);
		head.next.next           = new ListNode(3);
		head.next.next.next      = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode temp = head;
		head.rand                     = temp.next.next;
		temp = head;
		head.next.rand                = temp;
		temp = head;
		head.next.next.rand           = temp.next.next.next.next;
		temp = head;
		head.next.next.next.rand      = temp.next.next;
		temp = head;
		head.next.next.next.next.rand = temp.next;

		ListNode result = clone(head);
		temp = head;
		ListNode temp1 = result;
		while(temp != null && temp1 != null)
		{
			System.out.println(temp.val+"->"+temp.rand.val+"\t"+temp1.val+"->"+temp1.rand.val);
			temp = temp.next;
			temp1 = temp1.next;
		}
	}
	public static ListNode clone(ListNode h)
	{
		if(h == null) return h;
		if(h.next == null)
		{
			ListNode ret = new ListNode(h.val);
			if(h.rand != null) ret.rand = ret;
			return ret;
		}
		ListNode original = h;
		while(original != null)
		{
			ListNode temp = new ListNode(original.val);
			temp.next = original.next;
			original.next = temp;
			original = original.next.next;
		}
		original = h;
		while(original != null)
		{
			original.next.rand = ((original.rand != null) ? original.rand.next : original.rand);
			original = original.next.next;
		}

		original = h;
		ListNode copy = original.next;
		ListNode copystore = copy;
		while(original != null && copy != null)
		{
			original.next = ((original.next != null) ? original.next.next : original.next);
			copy.next = ((copy.next != null) ? copy.next.next : copy.next);
			original = original.next;
			copy = copy.next;
		}
		return copystore;
	}
}

class ListNode
{
	int val;
	ListNode next, rand;
	ListNode(int a)
	{
		val = a;
		next = null;
		rand = null;
	}
}