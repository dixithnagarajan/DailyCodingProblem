import java.io.*;
import java.util.*;

public class Day14
{
	public static void main(String[] args) throws IOException
	{
		Random rx = new Random();
		Random ry = new Random();
		int high = 1_000_000;
		int cp = 0;
		int sp = 0;
		int i = 0;
		while(i<high)
		{
			double x = rx.nextDouble()-0.5;
			double y = ry.nextDouble()-0.5;

			double r2 = ((x*x)+(y*y));
			if(r2 <= 0.25) cp++;
			sp++;
			i++;
		}
		System.out.println(4*(cp/(sp+0.0)));
	}
}