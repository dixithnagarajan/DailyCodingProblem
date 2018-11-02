import java.io.*;
import java.util.*;

public class Day97<Key extends Comparable<Key>, Value>
{
	HashMap<Key, TreeMap<Integer, Value>> map = new HashMap<Key, TreeMap<Integer, Value>>();

	public Day97()
	{
		
	}

	public boolean set(Key k, Value v, int t)
	{
		if(map.containsKey(k))
		{
			TreeMap<Integer, Value> temp = map.get(k);
			temp.put(t,v);
			map.put(k,temp);
		}
		else
		{
			TreeMap<Integer, Value> temp = new TreeMap<Integer, Value>();
			temp.put(t,v);
			map.put(k,temp);
		}
		return true;
	}

	public Value get(Key k, int t)
	{
		if(!map.containsKey(k)) return null;
		int found = -1;
		int temp1 = -1;
		TreeMap<Integer, Value> temp = map.get(k);
		if(temp.containsKey(t)) return temp.get(t);
		for(int i: temp.keySet())
		{
			if(t < i)
			{
				found = i;
				break;
			}
			temp1 = i;
		}
		if(found == -1) return temp.pollLastEntry().getValue();
		if(temp1 == -1) return null;
		return temp.get(temp1);
	}
}