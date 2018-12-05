import java.io.*;
import java.util.*;

public class Day137
{
	int[] arr;
	int size;

	public Day137()
	{
		arr = null;
		size = 0;
	}

	public boolean init(int size)
	{
		if(size < 0) return false;
		this.size = size;

		if(size%32 == 0)
		{
			arr = new int[size/32];
			return true;
		}
		else
		{
			arr = new int[(size/32 + 1)];
			return true;
		}
	}

	public boolean set(int i, int val)
	{
		if(arr == null) return false;
		if(i < 0 || i >= this.size) return false;
		if(val == 0 || val == 1)
		{
			if (get(i) == val) return true;
			arr[val/32] |= 1 << (val%32);
		}
		return false;
	}

	public int get(int i)
	{
		if(arr == null || i>=this.size || i<0) return -1;
		return ((arr[i/32] & (1<<(i%32))) >> (i%32));
	}
}