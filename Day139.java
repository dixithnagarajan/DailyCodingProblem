import java.io.*;
import java.util.*;

public class Day139
{
	private Scanner sc1;
	private Scanner sc2;
	private String dup;

	public Day139(String source)
	{
		sc1 = new Scanner(source);
		sc2 = new Scanner(source);
		dup = (sc2.hasNext() ? sc2.next() : null);
	}

	public boolean hasNext()
	{
		return sc1.hasNext();
	}

	public String next()
	{
		dup = (sc2.hasNext() ? sc2.next() : null);
		return sc1.next();
	}

	public String peek()
	{
		return dup;
	}
}