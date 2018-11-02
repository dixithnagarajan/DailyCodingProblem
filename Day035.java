import java.io.*;
import java.util.*;

public class Day35
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inpString = br.readLine();
		br.close();
		char[] arr = inpString.toCharArray();
		modify(arr);
		System.out.println("\n"+(new String(arr)));
	}
	public static void modify(char[] c)
	{
		int i = 0;
		int j = 0;
		char[] k = {'R','B','G'};
		int ind = 0;
		while(i<c.length && ind<3)
		{
			while(j<c.length)
			{
				if(c[j] == k[ind])
				{
					char temp = c[i];
					c[i] = c[j];
					c[j] = temp;
					i++;
				}
				j++;
			}
			ind++;
			j = i;
		}
	}
}