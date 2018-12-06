import java.io.*;
import java.util.*;

public class Day141
{
	private ArrayList<Integer> list;
	private int fB;
	private int sB;
	private int tB;

	public Day141()
	{
		list = new ArrayList<Integer>();
		fB = sB = tB = -1;
	}

	public boolean push(int item, int stack_number)
	{
		if(stack_number == 1)
		{
			if(sB >= 0) sB++;
			if(tB >= 0) tB++;

			fB++;
			list.add(0, item);
			return true;
		}
		else if(stack_number == 2)
		{
			if(sB < 0)
			{
				sB = fB+1;
				if(tB >= 0) tB++;
				list.add(sB, item);
			}
			else
			{
				if(tB >= 0)
				{
					tB++;
					list.add(tB-1, item);
				}
				else
				{
					list.add(item);
				}
			}
			return true;
		}
		else if(stack_number == 3)
		{
			if(tB < 0)
			{
				tB = list.size();
			}
			list.add(item);
			return true;
		}
		return false;
	}

	public int pop(int stack_number)
	{
		if(stack_number == 1)
		{
			if(fB < 0) return -1;
			if(fB >= 0) fB--;
			if(sB >= 0) sB--;
			if(tB >= 0) tB--;
			return list.remove(0);
		}
		else if(stack_number == 2)
		{
			if(sB < 0) return -1;
			if(tB < 0)
			{
				if(sB == list.size()-1) sB = -1;
				return list.remove(list.size()-1);
			}
			else
			{
				tB--;
				if(sB == tB) sB = -1;
				return list.remove(tB);
			}
		}
		else if(stack_number == 3)
		{
			if(tB < 0) return -1;
			if(tB == list.size()-1) tB = -1;
			return list.remove(list.size()-1);
		}
		return -1;
	}

	public void print()
	{
		System.out.println(list.toString()+" "+fB+" "+sB+" "+tB);
	}
}
