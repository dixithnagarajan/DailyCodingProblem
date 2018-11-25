import java.io.*;
import java.util.*;

public class Day129
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Double.parseDouble(br.readLine());
		br.close();

		double result = squareRoot(n);
		System.out.println(result+" "+Math.sqrt(n));
	}
	public static double squareRoot(double d)
	{
		if(d < 0) return -1.0;
		double error = 0.0001;
		double h = 0;
		double ret = 1;
		h = func(ret, d)/dervFunc(ret);
		while(Math.abs(h) > error)
		{
			h = func(ret, d)/dervFunc(ret);
			ret = ret-h;
		}
		return ret;
	}
	private static double func(double x, double d)
	{
		return (x*x - d);
	}
	private static double dervFunc(double x)
	{
		return 2*x;
	}
}