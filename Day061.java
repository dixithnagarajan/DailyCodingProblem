import java.io.*;
import java.util.*;

public class Day61
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());

		if(x < 0)
		{
			System.out.println("The function x^y is not well defined for x<0. Exiting");
		}
		else if(x == 0)
		{
			System.out.println("0");
		}
		else if(x == 1)
		{
			System.out.println("1");
		}
		else if(y == 0)
		{
			System.out.println("1");
		}
		else if(y == 1)
		{
			System.out.println(x);
		}
		else if(y == -1)
		{
			System.out.println("0");
		}
		else
		{
			System.out.println(power(x,y));
		}
	}
	public static int power(int x, int y)
	{
		if(y == 1) return x;
		if(y == 0) return 1;

		int temp = power(x,y/2);
		if(y%2 == 0) return temp*temp;
		else return x*temp*temp;
	}
}