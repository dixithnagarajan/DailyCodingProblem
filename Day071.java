import java.io.*;
import java.util.*;

public class Day71
{
	Random r;
	public Day71()
	{
		r = new Random();
	}
	public int rand5()
	{
		int i = rand7();
		while(i>=6)
		{
			i = rand7();
		}
		return i;
	}
	private int rand7()
	{
		return 1+r.nextInt(7);
	}
}