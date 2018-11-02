import java.io.*;
import java.util.*;

public class Day101
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		if(n<=2)
		{
			System.out.println("Please enter a valid input");
		}
		else if((n&1) == 1)
		{
			System.out.println("Please enter an even input");
		}
		else
		{
			int[] result = goldbach(n);
			System.out.println(n+" = "+result[0]+" + "+result[1]);
		}
	}
	public static int[] goldbach(int n)
	{
		boolean[] sieve = new boolean[n+1];
		sieve[0] = true;
		sieve[1] = true;
		for(int i=2;i<n;i++)
		{
			if(sieve[i]) continue;
			for(int j=2*i;j<n;j+=i)
			{
				sieve[j] = true;
			}
		}

		int l = 2;
		int r = n-2;
		while(sieve[l])
		{
			l++;
		}
		while(sieve[r])
		{
			r--;
		}
		while(l<=r)
		{
			if(l+r == n) return new int[]{l,r};
			if(l+r > n)
			{
				r--;
				while(sieve[r])
				{
					r--;
				}
			}
			else
			{
				l++;
				while(sieve[l])
				{
					l++;
				}
			}
		}
		return new int[]{-1,-1};
	}
}