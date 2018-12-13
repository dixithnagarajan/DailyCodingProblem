import java.io.*;
import java.util.*;

public class Day148
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> result = greyCode(n);
		System.out.println("\n"+result.toString());
	}
	public static List<String> greyCode(int n)
	{
		if(n < 0) return null;
		if(n == 0) return new ArrayList<String>();

		List<String> prev = new ArrayList<String>();
		prev.add("0");
		prev.add("1");
		if(n == 1) return prev;
		List<String> curr = null;
		for(int i=0;i<(n-1);i++)
		{
			curr = new ArrayList<String>();
			for(int j=0;j<prev.size();j++)
			{
				curr.add(prev.get(j));
			}
			Collections.reverse(prev);
			for(int j=0;j<prev.size();j++)
			{
				curr.add(prev.get(j));
			}
			int m = curr.size();
			for(int j=0;j<(m/2);j++)
			{
				curr.set(j, "0"+curr.get(j));
			}
			for(int j=(m/2);j<m;j++)
			{
				curr.set(j, "1"+curr.get(j));
			}
			prev = curr;
		}
		return curr;
	}
}
