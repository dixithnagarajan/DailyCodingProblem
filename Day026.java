import java.io.*;
import java.util.*;

public class Day26
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputString = br.readLine().split(" ");
		int k = Integer.parseInt(br.readLine());
		br.close();
		ListNode head = new ListNode(Integer.parseInt(inputString[0]));
		ListNode temp = head;
		for(int i=1;i<inputString.length;i++)
		{
			temp.next = new ListNode(Integer.parseInt(inputString[i]));
			temp = temp.next;
		}

		temp = head;
		System.out.println("Before deleting the node -");
		while(temp!=null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println();
		temp = head;
		ListNode slow = head;
		ListNode fast = head;
		for(int i=0;i<k;i++)
		{
			fast = fast.next;
		}
		while(fast!=null)
		{
			temp = slow;
			slow = slow.next;
			fast = fast.next;
		}
		temp.next = slow.next;
		temp = head;
		System.out.println("After deleting the node -");
		while(temp!=null)
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