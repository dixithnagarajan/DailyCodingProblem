import java.io.*;
import java.util.*;

public class Day138
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int result = changeMaker(n);
		System.out.println("\n"+result);
	}
	public static int changeMaker(int n)
	{
		int[] change = new int[4];

		change[0] = n/25;
		n = n%25;
		change[1] = n/10;
		n = n%10;
		change[2] = n/5;
		n = n%5;
		change[3] = n/1;
		n = n%1;

		return change[0]+change[1]+change[2]+change[3];
	}
}