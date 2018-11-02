import java.io.*;
import java.util.*;

public class Day85
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		br.close();
		int result = magic(x,y,b);
		System.out.println("\n\n"+result);
	}
	public static int magic(int x, int y, int b)
	{
		return (x+y-(b*x)-((1-b)*y));
	}
}