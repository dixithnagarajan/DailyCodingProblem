import java.io.*;
import java.util.*;

public class Day15
{
	public static void main(String[] args)
	{
		System.out.println("################################################");
		System.out.println("Please enter numbers in each line and when you\nwant to stop, enter a non-digit character");
		System.out.println("################################################\n");
		Scanner sc = new Scanner(System.in);
		int res = 0;
		int count = 0;
		Random r = new Random();
		while(sc.hasNextInt())
		{
			int x = sc.nextInt();
			if(count == 0)
			{
				res = x;
				count++;
			}
			else
			{
				int y = r.nextInt(count);
				if(y == count-1) res = x;
			}
			count++;
		}
		System.out.println(res);
	}
}