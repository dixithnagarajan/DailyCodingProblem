import java.io.*;
import java.util.*;

public class Day108
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		br.close();

		boolean result = canDo(A, B);
		System.out.println("\n"+result);
	}
	public static boolean canDo(String A, String B)
	{
		if(A == null || B == null) return false;
		if(A.length() == 0 && B.length() == 0) return true;
		if(A.length() == 0 || B.length() == 0) return true;
		if(A.length() != B.length()) return false;
		A = A+A;
		return (A.indexOf(B) > 0);
	}
}