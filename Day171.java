import java.io.*;
import java.util.*;

public class Day171
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		List<Entry> entryList = new ArrayList<Entry>();
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().trim().split("\\s+");
			entryList.add(new Entry(Long.parseLong(inpString[0]), Integer.parseInt(inpString[1]), inpString[2]));
		}
		br.close();
		Long[] result = mostCrowded(entryList);
		System.out.println("\n\nstart - "+result[0]+", end - "+result[1]);
	}
	public static Long[] mostCrowded(List<Entry> eList)
	{
		eList = removeZeroEntries(eList);
		Collections.sort(eList, new Comparator<Entry>(){public int compare(Entry e1, Entry e2){return Long.compare(e1.timestamp, e2.timestamp);}});
		long maxcrowd = -1l;
		long currcrowd = 0l;
		long start = -1l;
		long end = -1l;
		boolean checkExitTime = false;
		for(Entry e: eList)
		{
			if(e.type.equals("enter"))
			{
				currcrowd += e.count;
				if(currcrowd > maxcrowd)
				{
					maxcrowd = currcrowd;
					start = e.timestamp;
					checkExitTime = true;
				}
			}
			else
			{
				currcrowd -= e.count;
				if(checkExitTime)
				{
					end = e.timestamp;
					checkExitTime = false;
				}
			}
		}
		return new Long[]{start, end};
	}
	private static List<Entry> removeZeroEntries(List<Entry> el)
	{
		int n = el.size();
		boolean[] withZero = new boolean[n];
		int i = 0;
		for(Entry e: el)
		{
			if(e.count == 0) withZero[i] = true;
			i++;
		}
		List<Entry> newList = new ArrayList<Entry>();
		for(i=0;i<n;i++)
		{
			if(!withZero[i]) newList.add(el.get(i));
		}
		return newList;
	}
}

class Entry
{
	long timestamp;
	int count;
	String type;
	Entry(long a, int b, String c)
	{
		this.timestamp = a;
		this.count = b;
		this.type = c;
	}
	public String toString()
	{
		return "{ timestamp: "+timestamp+", count: "+count+", type: "+type+" }";
	}
}
