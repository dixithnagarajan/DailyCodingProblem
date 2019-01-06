import java.io.*;
import java.util.*;

public class Day172
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().trim().split("\\s+");
		String s = br.readLine().trim();
		br.close();
		ArrayList<Integer> result = findSubString(s, words);
		if(result == null) System.out.println("null");
		else System.out.println(result.toString());
	}
	public static ArrayList<Integer> findSubString(String s, String[] w)
	{
		ArrayList retVal = new ArrayList<Integer>();
		if(s==null || s.length()==0 || w==null || w.length==0) return retVal;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int m = w[0].length();
		for(String i: w)
		{
			if(i.length() != m) return retVal;
			if(map.containsKey(i)) map.put(i, map.get(i)+1);
			else map.put(i, 1);
		}
		for(int i=0;i<m;i++)
		{
			int start = i;
			int count = 0;
			HashMap<String, Integer> currMap = new HashMap<String, Integer>();
			for(int j=i;j<=s.length()-m;j+=m)
			{
				String sub = s.substring(j, j+m);
				if(map.containsKey(sub))
				{
					if(currMap.containsKey(sub)) currMap.put(sub, currMap.get(sub)+1);
					else currMap.put(sub, 1);
					count++;
					while(currMap.get(sub) > map.get(sub))
					{
						String left = s.substring(start, start+m);
						currMap.put(left, currMap.get(left)-1);
						count--;
						start+=m;
					}
					if(count == w.length)
					{
						retVal.add(start);
						String left = s.substring(start, start+m);
						currMap.put(left, currMap.get(left)-1);
						count--;
						start+=m;
					}
				}
				else
				{
					currMap.clear();
					start = j+m;
					count = 0;
				}
			}
		}
		return retVal;
	}
}
