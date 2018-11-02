import java.io.*;
import java.util.*;

public class Day45
{
	Random r;

	public Day45()
	{
		r = new Random();
	}

	public int rand5()
	{
		return (r.nextInt(5)+1);
	}

	public int rand7()
	{
		int i = (5*(rand5() - 1)+rand5());
		while(i > 21)
		{
			i = (5*(rand5() - 1)+rand5());
		}

		return ((i%7)+1);
	}

	public static void main(String[] args)
	{
		Day45 d = new Day45();
		for(int i=0;i<30;i++)
		{
			System.out.println(d.rand7());
		}
	}
}