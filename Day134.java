import java.io.*;
import java.util.*;

public class Day134
{
	private HashMap<Integer, Integer> map;
	private int size;

	public Day134()
	{
		map = new HashMap<Integer, Integer>();
		size = 0;
	}

	public boolean init(int[] arr, int n)
	{
		size = n;
		for(int i=0;i<n;i++)
		{
			if(arr[i] != 0)
			{
				map.put(i, arr[i]);
			}
		}
		return true;
	}

	public boolean set(int i, int val)
	{
		map.put(i, val);
		return true;
	}

	public int get(int i)
	{
		return map.get(i);
	}
}