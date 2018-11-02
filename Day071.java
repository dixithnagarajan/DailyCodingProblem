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
		int i = 7*rand7()+rand7()-7;
		while(i>=46)
		{
			i = 7*rand7()+rand7()-7;
		}
		return ((i%5) +1);
	}
	private int rand7()
	{
		return 1+r.nextInt(7);
	}
}