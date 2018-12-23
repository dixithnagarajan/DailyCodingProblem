import java.io.*;
import java.util.*;

public class Day154
{
	PriorityQueue<Pair> pq;
	int count;
	public Day154()
	{
		count = 0;
		pq = new PriorityQueue<Pair>(new Comparator<Pair>(){public int compare(Pair p1, Pair p2){if(p1.ts > p2.ts) return -1;if(p1.ts < p2.ts) return 1; return 0;}});
	}

	public int size()
	{
		return pq.size();
	}
	public void push(int val)
	{
		pq.add(new Pair(val, count));
		count++;
	}
	public int pop()
	{
		return pq.poll().val;
	}
}

class Pair
{
	int val, ts;
	Pair(int a, int b)
	{
		val = a;
		ts = b;
	}
}
