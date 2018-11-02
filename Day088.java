import java.io.*;
import java.util.*;

public class Day88
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dividend = Integer.parseInt(br.readLine());
		int divisor = Integer.parseInt(br.readLine());
		br.close();
		int result = divide(dividend, divisor);
		System.out.println(result);
	}
	public static int divide(int dividend, int divisor)
	{
		if(dividend == 0) return 0;
		if(dividend == divisor) return 1;
		if(divisor == 1) return dividend;
		int sign = 1;
		if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) sign=-1;
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);

		if(ldividend == ldivisor) return sign*1;
		if(ldividend < ldivisor) return 0;

		long lans = divideLong(ldividend, ldivisor);
		if(lans >= Integer.MAX_VALUE)
		{
			if(sign == 1) return Integer.MAX_VALUE;
			return Integer.MIN_VALUE;
		}
		return (int)(sign*lans);
	}
	private static long divideLong(long ldividend, long ldivisor)
	{
		if(ldividend < ldivisor) return 0;
		if(ldivisor == 1) return ldividend;

		long sum = ldivisor;
		int mul = 1;
		while((sum+sum) <= ldividend)
		{
			sum = sum+sum;
			mul = mul+mul;
		}
		return mul+divideLong(ldividend-sum, ldivisor);
	}
}