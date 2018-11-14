import java.io.*;
import java.util.*;

public class Day120
{
	private static int count = 1;
	public String var;
	private static Day120 odd_instance = null;
	private static Day120 even_instance = null;

	private Day120()
	{
		if((count & 1) == 1)
		{
			var = "odd";
		}
		else var = "even";
	}

	public static Day120 getInstance()
	{
		if((count & 1) == 1)
		{
			if(odd_instance == null) odd_instance = new Day120();
			count++;
			return odd_instance;
		}
		else
		{
			if(even_instance == null) even_instance = new Day120();
			count++;
			return even_instance;
		}
	}
}