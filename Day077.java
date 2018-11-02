import java.io.*;
import java.util.*;

public class Day77
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Interval[] intervals = new Interval[n];
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().split(" ");
			intervals[i] = new Interval(Integer.parseInt(inpString[0]), Integer.parseInt(inpString[1]));
		}
		br.close();
		System.out.print("[");
		for(int i=0;i<intervals.length;i++)
		{
			System.out.print("("+intervals[i].s+","+intervals[i].e+") ");
		}
		System.out.println("]");
		Interval[] result = mergeIntervals(intervals);
		System.out.print("[");
		for(int i=0;i<result.length;i++)
		{
			System.out.print("("+result[i].s+","+result[i].e+") ");
		}
		System.out.println("]");
	}
	public static Interval[] mergeIntervals(Interval[] intervals)
	{
		Arrays.sort(intervals, new Comparator<Interval>(){public int compare(Interval i1, Interval i2){if(i1.s > i2.s) return -1;if(i1.s < i2.s) return 1; return 0;}});
		int index = 0;
		for(int i=0;i<intervals.length;i++)
		{
			if(index>0 && (intervals[index-1].s <= intervals[i].e))
			{
				while(index>0 && (intervals[index-1].s <= intervals[i].e))
				{
					intervals[index-1].s = Math.min(intervals[index-1].s, intervals[i].s);
					intervals[index-1].e = Math.max(intervals[index-1].e, intervals[i].e);
					index--;
				}
			}
			else
			{
				intervals[index] = intervals[i];
			}
			index++;
		}
		Interval[] retVal = new Interval[index];
		for(int i=0;i<index;i++)
		{
			retVal[i] = intervals[i];
		}
		return retVal;
	}
}

class Interval
{
	int s;
	int e;
	Interval(int a, int b)
	{
		s = a;
		e = b;
	}
}