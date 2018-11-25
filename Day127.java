import java.io.*;
import java.util.*;

public class Day127
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num1String = br.readLine().split(" ");
		String[] num2String = br.readLine().split(" ");
		br.close();
		ListNode l1temp = new ListNode(Integer.parseInt(num1String[0]));
		ListNode l2temp = new ListNode(Integer.parseInt(num2String[0]));
		ListNode l1 = l1temp;
		ListNode l2 = l2temp;

		for(int i=1;i<num1String.length;i++)
		{
			l1temp.next = new ListNode(Integer.parseInt(num1String[i]));
			l1temp = l1temp.next;
		}

		for(int i=1;i<num2String.length;i++)
		{
			l2temp.next = new ListNode(Integer.parseInt(num2String[i]));
			l2temp = l2temp.next;
		}

		ListNode result = addLists(l1, l2);
		ListNode temp = result;
		while(temp != null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
	}
	public static ListNode addLists(ListNode a, ListNode b)
	{
		ListNode retstore = null;
		if(a == null && b == null) return retstore;
		if(a == null) return b;
		if(b == null) return a;
		ListNode ret = retstore;
		int sum = 0;
		int carry = 0;
		while(a!=null && b!=null)
		{
			sum = (a.val+b.val+carry)%10;
			carry = (a.val+b.val+carry)/10;

			if(retstore == null)
			{
				retstore = new ListNode(sum);
				ret = retstore;
			}
			else
			{
				retstore.next = new ListNode(sum);
				retstore = retstore.next;
			}

			a = a.next;
			b = b.next;
		}
		if(b == null)
		{
			while(a != null)
			{
				sum = (a.val+carry)%10;
				carry = (a.val+carry)/10;

				retstore.next = new ListNode(sum);
				retstore = retstore.next;
				a = a.next;
			}
		}
		else if(a == null)
		{
			while(b != null)
			{
				sum = (b.val+carry)%10;
				carry = (b.val+carry)/10;

				retstore.next = new ListNode(sum);
				retstore = retstore.next;
				b = b.next;
			}
		}

		if(carry != 0)
		{
			retstore.next = new ListNode(carry);
		}

		return ret;
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