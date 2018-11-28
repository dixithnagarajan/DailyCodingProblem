import java.io.*;
import java.util.*;

public class Day132
{
	HashMap<Integer, Integer> set;
	int numHits;

	public Day132()
	{
		set = new HashMap<Integer, Integer>();
		int numHits = 0;
	}

	public boolean record(int timestamp)
	{
		if(set.containsKey(timestamp))
		{
			set.put(timestamp, set.get(timestamp)+1);
			return true;
		}
		set.put(timestamp, 1);
		numHits++;
		return true;
	}

	public int total()
	{
		return numHits;
	}

	public int range(int lower, int higher)
	{
		int ret = 0;
		for(int i=lower;i<=higher;i++)
		{
			ret += ((set.containsKey(i))?set.get(i):0);
		}
		return ret;
	}
}