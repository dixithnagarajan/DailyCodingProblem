import java.io.*;
import java.util.*;

public class TrieNode
{
	public char c;
	public boolean isEnd;
	public HashMap<Character, TrieNode> kinder;
	public int size;

	public TrieNode()
	{
		this.c = '0';
		size = 0;
		this.kinder = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
	public TrieNode(char c)
	{
		this.c = c;
		size = 0;
		this.kinder = new HashMap<Character, TrieNode>();
	}

	public void add(String s)
	{
		if((s == null) || (s.length() == 0)) return;
		int i = 0;
		TrieNode temp = this;
		for(i=0;i<s.length();i++)
		{
			if(temp.kinder.get(s.charAt(i)) == null)
			{
				temp.kinder.put(s.charAt(i), new TrieNode(s.charAt(i)));
			}
			temp = temp.kinder.get(s.charAt(i));
		}
		temp.isEnd = true;
	}

	public boolean isAWord(String s)
	{
		if(s == null) return false;
		if(s.length() == 0) return true;
		TrieNode temp = this;
		for(int i=0;i<s.length();i++)
		{
			if(temp.kinder.get(s.charAt(i)) == null) return false;
			temp = temp.kinder.get(s.charAt(i));
		}
		return (temp!=null && temp.isEnd);
	}

	public ArrayList<String> search(String s)
	{
		if(s == null) return null;
		if(s.length() == 0) return this.allStrings(this, "");
		ArrayList<String> retVal = new ArrayList<String>();
		int i=0;
		TrieNode temp = this;
		while(i<s.length())
		{
			if(temp.kinder.get(s.charAt(i)) == null) return retVal;
			temp = temp.kinder.get(s.charAt(i));
			i++;
		}
		retVal = allStrings(temp, s);
		return retVal;
	}

	public ArrayList<String> allStrings(TrieNode t, String s)
	{
		char[] path = new char[1000];
		int plen = 0;
		ArrayList<String> ret = new ArrayList<String>();
		allStrings(t, path, plen, ret, s);
		return ret;
	}
	private void allStrings(TrieNode t, char[] path, int plen, ArrayList<String> l, String s)
	{
		if(t == null) return;
		path[plen] = t.c;
		plen++;
		if((t.isEnd))
		{
			printArray(path, plen, l, s);
		}
		for(TrieNode child: t.kinder.values())
		{
			allStrings(child, path, plen, l, s);
		}
	}
	private void printArray(char[] path, int len, ArrayList<String> l, String s) 
	{
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<len;i++)
		{
			sb.append(path[i]);
		}
		l.add(s+sb.toString());
	}

	//For debugging purposes
	public void print()
	{
		LinkedList<TrieNode> q = new LinkedList<TrieNode>();
		TrieNode temp = this;
		q.add(temp);
		q.add(null);
		while(!q.isEmpty())
		{
			TrieNode t = q.removeFirst();
			if(t == null)
			{
				System.out.println();
				if(!q.isEmpty()) q.add(null);
			}
			else
			{
				if(!t.isEnd) System.out.print(t.c+" ");
				else System.out.print(t.c+"* ");
				for(TrieNode child: t.kinder.values())
				{
					q.add(child);
				}
			}
		}
	}
}