import java.io.*;
import java.util.*;

public class Day70
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		int ans = 19;
		while(n>1)
		{
			ans+=9;
			if(isValid(ans)) n--;
		}
		System.out.println(ans);
	}
	private static boolean isValid(int a)
	{
		String s = a+"";
		int sum = 0;
		for(int i=0;i<s.length();i++)
		{
			sum+=(s.charAt(i)-'0');
		}
		return (sum==10);
	}
}