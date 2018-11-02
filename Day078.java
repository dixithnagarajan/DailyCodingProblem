import java.io.*;
import java.util.*;

public class Day078
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Node[] list = new Node[k];
		for(int i=0;i<k;i++)
		{
			String[] inpString = br.readLine().split(" ");
			list[i] = new Node(Integer.parseInt(inpString[0]));
			Node temp = list[i];
			for(int j=1;j<inpString.length;j++)
			{
				temp.next = new Node(Integer.parseInt(inpString[j]));
				temp = temp.next;
			}
		}

		Node result = merge(list);
		Node temp = result;
		while(temp != null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
	}
	public static Node merge(Node[] l)
	{
		if(l == null) return null;
		if(l.length == 1) return l[0];

		Node retVal = null;
		Node retValHolder = retVal;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){public int compare(Node n1, Node n2){if(n1.val == n2.val) return 0;if(n1.val < n2.val) return -1; return 1;}});
		for(int i=0;i<l.length;i++)
		{
			if(l[i] != null) pq.add(l[i]);
		}

		while(pq.size() != 0)
		{
			Node t = pq.poll();
			if(retVal == null)
			{
				retVal = t;
				retValHolder = retVal;
			}
			else
			{
				retVal.next = t;
				retVal = retVal.next;
			}

			t = t.next;
			if(t != null)
			{
				pq.add(t);
			}
		}

		return retValHolder;
	}
}

class Node
{
	int val;
	Node next;
	Node(int a)
	{
		val = a;
		next = null;
	}
}