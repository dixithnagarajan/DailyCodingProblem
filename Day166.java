import java.io.*;
import java.util.*;

public class Day166
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().trim().split(" ");
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=0;j<inpString.length;j++)
			{
				if(inpString[j].length() > 0) temp.add(Integer.parseInt(inpString[j]));
			}
			list.add(temp);
		}
		MyIterator it = new MyIterator(list);
		while(it.hasNext()) System.out.print(it.next()+" ");
		System.out.println();
	}
}

class MyIterator
{
	int iter;
	ArrayList<Integer> l;
	MyIterator(ArrayList<ArrayList<Integer>> a)
	{
		iter = -1;
		l = new ArrayList<Integer>();
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i) != null)
			{
				for(int j=0;j<a.get(i).size();j++)
				{
					int temp = (a.get(i).get(j));
					this.l.add(temp);
				}
			}
		}
	}
	boolean hasNext()
	{
		int j = iter+1;
		return (j>=0 && j<this.l.size());
	}
	Integer next()
	{
		if(iter == this.l.size()) return null;
		return this.l.get(++iter);
	}
}
